package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datatypes.Hall;


import junit.framework.TestCase;

/**
 * Testing our DBFacade.
 * 
 * @author swe.uni-due.de
 *
 */
public class DBFacadeTest extends TestCase {

	private Performance testPnonArchived;
	private Performance testPArchived;
	private CustomerAccount testCA;

	/**
	 * Preparing classes with static methods
	 */
	@Before
	public void setUp() {

		// Performance object to be tested
		testPnonArchived = new Performance(100, "TestPerformaceNonArchived", 240, Timestamp.valueOf("2023-12-31 00:00:00"), new Hall(1,4,10), 30, false);
		testPArchived = new Performance(200, "TestPerformaceArchived", 240, Timestamp.valueOf("2023-12-31 00:00:00"), new Hall(1,4,10), 30, true);
		testCA = new CustomerAccount("test@test.com","test123");
		/*ArrayList<CustomerAccount> testAccounts = new ArrayList<CustomerAccount>();
		testAccounts.add(testCA);*/

		// SQL statements
		String sqlCleanDB = "DROP TABLE IF EXISTS performance,customeraccount";
		String sqlCreateTableCA = "CREATE TABLE customeraccount (email varchar(255) UNIQUE NOT NULL, password varchar(255) NOT NULL);";
		String sqlCreateTableP = "CREATE TABLE performance (ID int(11) NOT NULL AUTO_INCREMENT, title varchar(255) NOT NULL,duration int(11) NOT NULL,time timestamp NOT NULL,assignedHall_ID int(11) NOT NULL,assignedHall_row int(11) NOT NULL,assignedHall_seatsInRow int(11) NOT NULL, availableSeats int(11) NOT NULL, isArchived BIT, PRIMARY KEY (ID));";
		String sqlInsertP= "INSERT INTO Performance (ID,title,duration,time,assignedHall_ID,assignedHall_row,assignedHall_seatsInRow,availableSeats,isArchived) VALUES (?,?,?,?,?,?,?,?,?)";
		String sqlInsertCA = "INSERT INTO CustomerAccount(email,password) VALUES (?,?)";

		// Perform database updates
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
			try (PreparedStatement psCreateBooking = connection.prepareStatement(sqlCreateTableCA)) {
				psCreateBooking.executeUpdate();
			}
			try (PreparedStatement psCreateHolidayOffer = connection.prepareStatement(sqlCreateTableP)) {
				psCreateHolidayOffer.executeUpdate();
			}
			try (PreparedStatement psInsertOffer = connection.prepareStatement(sqlInsertP)) {
				psInsertOffer.setInt(1, testPnonArchived.getID());
				psInsertOffer.setString(2, testPnonArchived.getTitle());
				psInsertOffer.setInt(3, testPnonArchived.getDuration());
				psInsertOffer.setTimestamp(4, testPnonArchived.getTime());
				psInsertOffer.setInt(5, testPnonArchived.getAssignedHall().getNr());
				psInsertOffer.setInt(6, testPnonArchived.getAssignedHall().getRow());
				psInsertOffer.setInt(7, testPnonArchived.getAssignedHall().getSeatsInRow());
				psInsertOffer.setInt(8, testPnonArchived.getAvailableSeats());
				psInsertOffer.setBoolean(9, testPnonArchived.getIsArchived());
				psInsertOffer.executeUpdate();
			}
			try (PreparedStatement psInsertOffer = connection.prepareStatement(sqlInsertP)) {
				psInsertOffer.setInt(1, testPArchived.getID());
				psInsertOffer.setString(2, testPArchived.getTitle());
				psInsertOffer.setInt(3, testPArchived.getDuration());
				psInsertOffer.setTimestamp(4, testPArchived.getTime());
				psInsertOffer.setInt(5, testPArchived.getAssignedHall().getNr());
				psInsertOffer.setInt(6, testPArchived.getAssignedHall().getRow());
				psInsertOffer.setInt(7, testPArchived.getAssignedHall().getSeatsInRow());
				psInsertOffer.setInt(8, testPArchived.getAvailableSeats());
				psInsertOffer.setBoolean(9, testPArchived.getIsArchived());
				psInsertOffer.executeUpdate();
			}
			try (PreparedStatement psInsertCA= connection.prepareStatement(sqlInsertCA)) {
				psInsertCA.setString(1, testCA.getEmail());
				psInsertCA.setString(2, testCA.getPassword());
				psInsertCA.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testing getPerformance with non-empty results.
	 */
	@Test
	public void testGetPerformance() {


		ArrayList<Performance> ps = DBFacade.getInstance().getPerformance();

		// Verify return values
		assertTrue(ps.size() == 1);
		assertTrue(ps.get(0).getID() == testPnonArchived.getID());
		assertTrue(ps.get(0).getTitle().equals(testPnonArchived.getTitle()));
		assertTrue(ps.get(0).getDuration().equals(testPnonArchived.getDuration()));
		assertTrue(ps.get(0).getTime().equals(testPnonArchived.getTime()));
		assertTrue(ps.get(0).getAssignedHall().equals(testPnonArchived.getAssignedHall()));
		assertTrue(ps.get(0).getAvailableSeats() == testPnonArchived.getAvailableSeats());
		assertTrue(ps.get(0).getIsArchived() == testPnonArchived.getIsArchived());
		//

	}

	/**
	 * Testing getPerformance with empty result.
	 */
	@Test
	public void testGetPerformanceEmpty() {

		ArrayList<Performance> ps = DBFacade.getInstance().getPerformance();

		// Verify return values
		assertFalse(ps.size() == 0);

	}


	/**
	 * Testing getCustomerAccount with non-empty results.
	 */
	@Test
	public void testGetCustomerAccount() {
		
		ArrayList<CustomerAccount> ca = DBFacade.getInstance().getCustomerAccount();

		// Verify return values
		assertTrue(ca.size() == 1);
		assertTrue(ca.get(0).getEmail().equals(testCA.getEmail()));
		assertTrue(ca.get(0).getPassword().equals(testCA.getPassword()));
		//

	}

	/**
	 * Reset database
	 */
	@After
	public void tearDown() {

		// SQL statements
		String sqlCleanDB = "DROP TABLE IF EXISTS performance,customeraccount";

		// Perform database updates
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
