package interfaces;

import java.util.ArrayList;
import dbadapter.*;

public interface RCCmds {
	public ArrayList<Performance> forwardRequestPerformance();
	public Booking forwardRequestBooking(Integer pID, CustomerAccount customerAccount, Integer seatsCount);
}
