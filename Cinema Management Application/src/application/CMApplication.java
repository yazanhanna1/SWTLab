package application;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import datatypes.Hall;
import dbadapter.Booking;
import dbadapter.CustomerAccount;
import dbadapter.DBFacade;
import dbadapter.Performance;
import interfaces.*;

/**
 * This class contains the CinemaManagmentApplication which acts as the interface between all
 * components.
 * 
 * @author swe.uni-due.de
 *
 */
public class CMApplication implements URCCmds,RCCmds{
	private static CMApplication instance;
	
	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static CMApplication getInstance() {
		if (instance == null) {
			instance = new CMApplication();
		}
		return instance;
	}
	
	/**
	 * Calls DBFacace method to retrieve all unarchived performances
	 * 
	 *
	 * @return
	 */
	@Override
	public ArrayList<Performance> forwardRequestPerformance() {
		ArrayList<Performance> result = null;
		try {
			result = DBFacade.getInstance().getPerformance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Calls DBFacace method to Request the Regestration of the Account
	 * 
	 *
	 * @return
	 */
	@Override
	public CustomerAccount forwardRequestRegister(String email, String password) {
		CustomerAccount result = null;
		try {
			result = DBFacade.getInstance().addCustomerAccount(email, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Booking forwardRequestBooking(Integer pID, CustomerAccount customerAccount, Integer seatsCount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Forwards a new performance to the database.
	 * 
	 * @param title
	 * @param duration
	 * @param time
	 * @param assignedHall_ID
	 * @param assignedHall_row
	 * @param assignedHall_seatsInRow
	 * @param availableSeats
	 * @param isArchived
	 */
	public void insertPerformance(String title ,String duration,String time,String assignedHall_ID,String assignedHall_row,String assignedHall_seatsInRow,String availableSeats) {
		// Parse inputs to correct datatypes
		try {
			Integer durationSQL = Integer.parseInt(duration);
			LocalDateTime dateTime = LocalDateTime.parse(time);
			Timestamp timeSQL = Timestamp.valueOf(dateTime);
			Integer assignedHall_IDSQL = Integer.parseInt(assignedHall_ID);
			Integer assignedHall_rowSQL = Integer.parseInt(assignedHall_row);
			Integer assignedHall_seatsInRowSQL = Integer.parseInt(assignedHall_seatsInRow);
			Integer availableSeatsSQL = Integer.parseInt(availableSeats);
			DBFacade.getInstance().insertPerformance(title ,durationSQL,timeSQL,new Hall(assignedHall_IDSQL,assignedHall_rowSQL,assignedHall_seatsInRowSQL),availableSeatsSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
