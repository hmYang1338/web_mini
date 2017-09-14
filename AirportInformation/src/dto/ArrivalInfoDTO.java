package dto;

public class ArrivalInfoDTO {
	private String AflightID;
	private String AscheduleDateTime;
	private String airline;
	private String airport;

	public ArrivalInfoDTO() {}
	public ArrivalInfoDTO(String aflightID, String ascheduleDateTime, String airline, String airport) {
		super();
		AflightID = aflightID;
		AscheduleDateTime = ascheduleDateTime;
		this.airline = airline;
		this.airport = airport;
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
		builder.append("ArrivalInfoDTO [AflightID=");
		builder.append(AflightID);
		builder.append(", AscheduleStringTime=");
		builder.append(AscheduleDateTime);
		builder.append(", airline=");
		builder.append(airline);
		builder.append(", airport=");
		builder.append(airport);
		builder.append("]");
		return builder.toString();
	}
	
}
