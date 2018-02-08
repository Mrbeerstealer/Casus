package nl.sebastiaanklein.casus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	@Column
	private String lastName;
	@Column
	private boolean isAdmin;
	@Column
	private double xCoordinate;
	@Column
	private double yCoordinate;
	
	@OneToMany
	@JsonIgnore
	private List<UserEvent> userEventList;
	
	public User() {
		
	}
	
	public User(String name, String lastName, double xCoordinate, double yCoordinate) {
		this.name = name;
		this.lastName = lastName;
		this.isAdmin = false;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		userEventList = new ArrayList<>();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	
//	public boolean addToList(Event event) {
//		UserEvent userEvent = new UserEvent(id, event.getIdentifier());
//		for(UserEvent userEvents: userEventList) {
//			if(userEvents.equals(userEvent)) {
//				return false;
//			}
//		}
//		UserEventService UserEventService = new UserEventService();
//		UserEventService.create(userEvent);
//		if(userEventList.add(userEvent)) {
//			return true;
//		}
//		return false;
//	}
	
}
