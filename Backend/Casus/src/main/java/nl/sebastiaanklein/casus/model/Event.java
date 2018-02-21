package nl.sebastiaanklein.casus.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Long identifier;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private LocalDate date;
	@Column
	private EventType eventType;
	@Column
	private boolean privateStatus;
	@Column
	private double xCoordinate;
	@Column
	private double yCoordinate;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private List<UserEvent> userEventList;

	public Event() {
		
	}
	
	public Event(String name, String description, LocalDate date, EventType eventType, boolean privateStatus, double xCoordinate, double yCoordinate) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.eventType = eventType;
		this.privateStatus = privateStatus;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

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

	public boolean isPrivate() {
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
}
