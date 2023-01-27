package application;

import java.util.ArrayList;

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

	
	
}
