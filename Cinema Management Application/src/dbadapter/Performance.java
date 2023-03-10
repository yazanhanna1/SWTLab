package dbadapter;

import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.*;

public class Performance {
	private Integer ID;
	private String title;
	private Integer duration;
	private Timestamp time;
	private Hall assignedHall;
	private Integer availableSeats;
	private Boolean isArchived;
	private ArrayList<Booking> bookings;
	
	public Performance(Integer iD, String title, Integer duration, Timestamp time, Hall assignedHall,
			Integer availableSeats, Boolean isArchived) {
		super();
		ID = iD;
		this.title = title;
		this.duration = duration;
		this.time = time;
		this.assignedHall = assignedHall;
		this.availableSeats = availableSeats;
		this.isArchived = isArchived;
		this.bookings = new ArrayList<Booking>();
	}

	@Override
	public String toString() {
		return "Performance [ID=" + ID + ", title=" + title + ", duration=" + duration + ", time=" + time
				+ ", assignedHall=" + assignedHall + ", availableSeats=" + availableSeats + ", isArchived=" + isArchived
				+ "]";
	}

	public Integer calculatePrice(Integer seatsCount) {
		return seatsCount * 10; //Hardcoded 10€ for each Seat
	}

	public Integer getID() {
		return ID;
	}

	public String getTitle() {
		return title;
	}

	public Integer getDuration() {
		return duration;
	}

	public Timestamp getTime() {
		return time;
	}

	public Hall getAssignedHall() {
		return assignedHall;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public Boolean getIsArchived() {
		return isArchived;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}
}
