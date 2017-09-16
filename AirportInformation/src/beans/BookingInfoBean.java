package beans;

public class BookingInfoBean {
	private String bookingCode;
	private String id;
	private String AFlightID;
	private String AScheduledateTime;
	private String DFlightID;
	private String DScheduledateTime;
	
	public BookingInfoBean() {}
	public BookingInfoBean(String bookingCode, String id, String aFlightID, String aScheduledateTime, String dFlightID,
			String dScheduledateTime) {
		super();
		this.bookingCode = bookingCode;
		this.id = id;
		AFlightID = aFlightID;
		AScheduledateTime = aScheduledateTime;
		DFlightID = dFlightID;
		DScheduledateTime = dScheduledateTime;
	}
	
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAFlightID() {
		return AFlightID;
	}
	public void setAFlightID(String aFlightID) {
		AFlightID = aFlightID;
	}
	public String getAScheduledateTime() {
		return AScheduledateTime;
	}
	public void setAScheduledateTime(String aScheduledateTime) {
		AScheduledateTime = aScheduledateTime;
	}
	public String getDFlightID() {
		return DFlightID;
	}
	public void setDFlightID(String dFlightID) {
		DFlightID = dFlightID;
	}
	public String getDScheduledateTime() {
		return DScheduledateTime;
	}
	public void setDScheduledateTime(String dScheduledateTime) {
		DScheduledateTime = dScheduledateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingInfoDTO [bookingCode=");
		builder.append(bookingCode);
		builder.append(", id=");
		builder.append(id);
		builder.append(", AFlightID=");
		builder.append(AFlightID);
		builder.append(", AScheduledateTime=");
		builder.append(AScheduledateTime);
		builder.append(", DFlightID=");
		builder.append(DFlightID);
		builder.append(", DScheduledateTime=");
		builder.append(DScheduledateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
