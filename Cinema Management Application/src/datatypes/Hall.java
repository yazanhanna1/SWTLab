package datatypes;

public class Hall {
	private Integer Nr;
	private Integer row;
	private Integer seatsInRow;
	
	public Hall(Integer nr, Integer row, Integer seatsInRow) {
		super();
		Nr = nr;
		this.row = row;
		this.seatsInRow = seatsInRow;
	}
	
	public Integer numberOfSeats() {
		return row * seatsInRow;
	}

	public Integer getNr() {
		return Nr;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getSeatsInRow() {
		return seatsInRow;
	}
	
	public Boolean equals(Hall hall) {
		if (this.Nr == hall.Nr && this.row == hall.row && this.seatsInRow == hall.seatsInRow)
			return true;
		else 
			return false;
	}
}
