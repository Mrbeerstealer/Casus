package nl.sebastiaanklein.casus.dto;

public class UserEventDto {
	protected Long eventId;
	protected Long userId;
	protected String doesAttend;
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDoesAttend() {
		return doesAttend;
	}
	public void setDoesAttend(String doesAttend) {
		this.doesAttend = doesAttend;
	}
	
	
}
