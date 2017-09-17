package beans;

public class DepartBean {
	private String DFlightID;
	private String DScheduledateTime;
	private String airline;
	private String airport;
	
	public DepartBean() {}
	public DepartBean(String dFlightID, String dScheduledateTime, String airline, String airport) {
		super();
		DFlightID = dFlightID;
		DScheduledateTime = dScheduledateTime;
		this.airline = airline;
		this.airport = airport;
	}
	public DepartBean(String airport) {
		super();
		this.airport = airport;
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
		builder.append("DepartBean [DFlightID=");
		builder.append(DFlightID);
		builder.append(", DScheduledateTime=");
		builder.append(DScheduledateTime);
		builder.append(", airline=");
		builder.append(airline);
		builder.append(", airport=");
		builder.append(airport);
		builder.append("]");
		return builder.toString();
	}
	
}
