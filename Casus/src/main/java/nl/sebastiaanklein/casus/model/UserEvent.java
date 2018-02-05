package nl.sebastiaanklein.casus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserEvent {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private DoesAttend doesAttend;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private	Event event;

	public UserEvent() {
		doesAttend = DoesAttend.UNDECIDED;
	}
	
	public String toString() {
		return "" + user.getId() + event.getIdentifier();
	}

	public DoesAttend getDoesAttend() {
		return doesAttend;
	}

	public void doesAttend(DoesAttend doesAttend) {
		this.doesAttend = doesAttend;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
