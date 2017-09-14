package dto;

public class DepartInfoDTO {
	private String DflightID;
	private String DscheduleDateTime;
	private String airline;
	private String airport;

	public DepartInfoDTO() {}
	public DepartInfoDTO(String dflightID, String dscheduleDateTime, String airline, String airport) {
		super();
		DflightID = dflightID;
		DscheduleDateTime = dscheduleDateTime;
		this.airline = airline;
		this.airport = airport;
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
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartInfoDTO [DflightID=");
		builder.append(DflightID);
		builder.append(", DscheduleDateTime=");
		builder.append(DscheduleDateTime);
		builder.append(", airline=");
		builder.append(airline);
		builder.append(", airport=");
		builder.append(airport);
		builder.append("]");
		return builder.toString();
	}
	
}
