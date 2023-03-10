package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.Hall;
import interfaces.ICustomerAccount;
import interfaces.IPerformance;

public class DBFacade implements ICustomerAccount, IPerformance {
	private static DBFacade instance;
	
	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static DBFacade getInstance() {
		if (instance == null) {
			instance = new DBFacade();
		}
		return instance;
	}
	public static void setInstance(DBFacade dbfacade) {
		instance = dbfacade;
	}
	
	/**
	 * Adds a CustomerAccount into the database if email doesn't already exist
	 * 
	 * @param email
	 * @param password
	 * 
	 */
	public CustomerAccount addCustomerAccount(String email, String password) {
		CustomerAccount customerAccount = null; //if email already exists will be stored in this variable
		CustomerAccount cAccount = null; //if email does not exist will be stored in this variable and returned
		String sqlSelect = "SELECT * from CustomerAccount WHERE email = ?";
		String sqlInsert = "INSERT INTO CustomerAccount(email,password) VALUES (?,?)";
		
		// Add Customer Account into database.
				try (Connection connection = DriverManager
						.getConnection(
								"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
										+ Configuration.getPort() + "/" + Configuration.getDatabase(),
								Configuration.getUser(), Configuration.getPassword())) {

					try (PreparedStatement ps = connection.prepareStatement(sqlSelect);
							PreparedStatement updatePS = connection.prepareStatement(sqlInsert)) {
						
						ps.setString(1, email);
						try (ResultSet rs = ps.executeQuery()){
							if(rs.next()) {
								customerAccount = new CustomerAccount(email,password);
							}
						}
						if (customerAccount == null)
						{
									cAccount = new CustomerAccount(email,password);
									updatePS.setString(1, cAccount.getEmail());
									updatePS.setString(2, cAccount.getPassword());
									updatePS.executeUpdate();
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return cAccount;
	}

	/**
	 * Gets the list of CustomerAccounts that are in the database
	 */
	public ArrayList<CustomerAccount> getCustomerAccount(){
		ArrayList<CustomerAccount> result = new ArrayList<CustomerAccount>();
		String sqlSelect = "SELECT * from CustomerAccount";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			try(PreparedStatement ps = connection.prepareStatement(sqlSelect)){
				try (ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						CustomerAccount ca = new CustomerAccount(rs.getString(1),rs.getString(2));
						result.add(ca);
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();			
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Gets the list of Performances that are not archived from the database
	 */
	public ArrayList<Performance> getPerformance(){
		ArrayList<Performance> result = new ArrayList<Performance>();
		String sqlSelect = "SELECT * from Performance WHERE isArchived = false ORDER BY time ASC";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			
			try (PreparedStatement ps = connection.prepareStatement(sqlSelect)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()){
						Performance p = new Performance(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getTimestamp(4),
							new Hall(rs.getInt(5),rs.getInt(6),rs.getInt(7)),rs.getInt(8),rs.getBoolean(9));
						result.add(p);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Gets the list of Performances that are archived from the database
	 */
	public ArrayList<Performance> getArchivedPerformance(){
		ArrayList<Performance> result = new ArrayList<Performance>();
		String sqlSelect = "SELECT * from Performance WHERE isArchived = true ORDER BY time ASC";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			
			try (PreparedStatement ps = connection.prepareStatement(sqlSelect)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()){
						Performance p = new Performance(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getTimestamp(4),
							new Hall(rs.getInt(5),rs.getInt(6),rs.getInt(7)),rs.getInt(8),rs.getBoolean(9));
						result.add(p);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Adds a Performance into the database
	 * 
	 * @param title
	 * @param duration
	 * @param time
	 * @param assignedHall
	 * @param availableSeats
	 * @param isArchived
	 * 
	 */
	public void insertPerformance(String title ,Integer duration,Timestamp time,Hall assignedHall ,Integer availableSeats) {
			// Declare SQL query to insert offer.
			String sqlInsert = "INSERT INTO Performance (title,duration,time,assignedHall_ID,assignedHall_row,assignedHall_seatsInRow,availableSeats,isArchived) VALUES (?,?,?,?,?,?,?,?)";
			Boolean isArchived = false;
			// Insert offer into database.
			try (Connection connection = DriverManager
					.getConnection(
							"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
									+ Configuration.getPort() + "/" + Configuration.getDatabase(),
							Configuration.getUser(), Configuration.getPassword())) {

				try (PreparedStatement ps = connection.prepareStatement(sqlInsert)) {
					ps.setString(1, title);
					ps.setInt(2, duration);
					ps.setTimestamp(3, time);
					ps.setInt(4, assignedHall.getNr());
					ps.setInt(5, assignedHall.getRow());
					ps.setInt(6, assignedHall.getSeatsInRow());
					ps.setInt(7, availableSeats);
					ps.setBoolean(8, isArchived);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
