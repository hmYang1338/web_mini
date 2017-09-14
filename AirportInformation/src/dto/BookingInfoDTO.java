package dto;

import java.util.Date;

public class BookingInfoDTO {
	private String bookingCode;
	private String id;
	private String DflightID;
	private String DscheduleDateTime;
	private String AflightID;
	private String AscheduleDateTime;
	
	public BookingInfoDTO() {}
	public BookingInfoDTO(String bookingCode, String id, String dflightID, String dscheduleDateTime, String aflightID,
			String ascheduleDateTime) {
		super();
		this.bookingCode = bookingCode;
		this.id = id;
		DflightID = dflightID;
		DscheduleDateTime = dscheduleDateTime;
		AflightID = aflightID;
		AscheduleDateTime = ascheduleDateTime;
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
	public String getDflightID() {
		return DflightID;
	}
	public void setDflightID(String dflightID) {
		DflightID = dflightID;
	}
	public String getDscheduleDateTime() {
		return DscheduleDateTime;
	}
	public void setDscheduleDateTime(String dscheduleDateTime) {
		DscheduleDateTime = dscheduleDateTime;
	}
	public String getAflightID() {
		return AflightID;
	}
	public void setAflightID(String aflightID) {
		AflightID = aflightID;
	}
	public String getAscheduleDateTime() {
		return AscheduleDateTime;
	}
	public void setAscheduleDateTime(String ascheduleDateTime) {
		AscheduleDateTime = ascheduleDateTime;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingInfoDTO [bookingCode=");
		builder.append(bookingCode);
		builder.append(", id=");
		builder.append(id);
		builder.append(", DflightID=");
		builder.append(DflightID);
		builder.append(", DscheduleDateTime=");
		builder.append(DscheduleDateTime);
		builder.append(", AflightID=");
		builder.append(AflightID);
		builder.append(", AscheduleDateTime=");
		builder.append(AscheduleDateTime);
		builder.append("]");
		return builder.toString();
	}
}
