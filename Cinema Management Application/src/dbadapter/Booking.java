package dbadapter;

import java.sql.Timestamp;

public class Booking {
	private Integer ID;
	private Timestamp creationTime;
	private Integer seatsCount;
	private String customerEmail;
	private Integer price;
	private Integer pID; //for the Performance ID
	
	public Booking(Integer iD, Timestamp creationTime, Integer seatsCount, String customerEmail, Integer price,
			Integer pID) {
		super();
		ID = iD;
		this.creationTime = creationTime;
		this.seatsCount = seatsCount;
		this.customerEmail = customerEmail;
		this.price = price;
		this.pID = pID;
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(Integer seatsCount) {
		this.seatsCount = seatsCount;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getpID() {
		return pID;
	}
	public void setpID(Integer pID) {
		this.pID = pID;
	}

}


