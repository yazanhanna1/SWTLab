package interfaces;

import java.sql.Timestamp;

import datatypes.Hall;

/**
 * Interface that provides all methods for the interaction with the staffmember.
 * 
 * @author swe.uni-due.de
 *
 */
public interface SMCmds {

	public void insertPerformance(String title, Integer duration, Timestamp time, Hall assignedHall, Integer availableSeats, Boolean isArchived);

}
