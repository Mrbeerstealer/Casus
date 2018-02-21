package nl.sebastiaanklein.casus.dto;

import java.util.List;

import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.model.UserEvent;

public class UserDto {
	
	protected String name;
	protected String lastName;
	protected double xCoordinate;
	protected double yCoordinate;
	protected List<UserEvent> userEventList;
	
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
	
	public static final UserDto buildFromUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setLastName(user.getLastName());
		userDto.setxCoordinate(user.getxCoordinate());
		userDto.setyCoordinate(user.getyCoordinate());
		userDto.setUserEventList(user.getUserEventList());
		return userDto;
	}
}
