package nl.sebastiaanklein.casus.dto;

import java.time.LocalDate;
import java.util.List;

import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.EventType;
import nl.sebastiaanklein.casus.model.UserEvent;

public class EventDto {
	
	protected String name;
	protected String description;
	protected LocalDate date;
	protected EventType eventType;
	protected boolean privateStatus;
	protected double xCoordinate;
	protected double yCoordinate;
	protected List<UserEvent> userEventList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	public boolean isPrivateStatus() {
		return privateStatus;
	}
	public void setPrivateStatus(boolean privateStatus) {
		this.privateStatus = privateStatus;
	}
	public double getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public double getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public List<UserEvent> getUserEventList() {
		return userEventList;
	}
	public void setUserEventList(List<UserEvent> userEventList) {
		this.userEventList = userEventList;
	}
	
	public static final EventDto buildFromEvent(Event event) {
		EventDto eventDto = new EventDto();
		eventDto.setName(event.getName());
		eventDto.setDescription(event.getDescription());
		eventDto.setDate(event.getDate());
		eventDto.setxCoordinate(event.getxCoordinate());
		eventDto.setyCoordinate(event.getyCoordinate());
		eventDto.setUserEventList(event.getUserEventList());
		return eventDto;
	}
}
