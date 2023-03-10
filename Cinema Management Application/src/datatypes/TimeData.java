package datatypes;

public class TimeData {
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
	private Integer minute;
	
	public TimeData(Integer year, Integer month, Integer day, Integer hour, Integer minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getDay() {
		return day;
	}

	public Integer getHour() {
		return hour;
	}

	public Integer getMinute() {
		return minute;
	}
	
	
	
}
