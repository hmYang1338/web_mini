package dto;

public class ArrivalDTO {
	private String AFlightID;
	private String AScheduledateTime;
	private String airline;
	private String airport;
	
	public ArrivalDTO() {}
	public ArrivalDTO(String aFlightID, String aScheduledateTime, String airline, String airport) {
		super();
		AFlightID = aFlightID;
		AScheduledateTime = aScheduledateTime;
		this.airline = airline;
		this.airport = airport;
	}
	public ArrivalDTO(String airport) {
		super();
		this.airport = airport;
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
		builder.append("DepartDTO [AFlightID=");
		builder.append(AFlightID);
		builder.append(", AScheduledateTime=");
		builder.append(AScheduledateTime);
		builder.append(", airline=");
		builder.append(airline);
		builder.append(", airport=");
		builder.append(airport);
		builder.append("]");
		return builder.toString();
	}
	
}
