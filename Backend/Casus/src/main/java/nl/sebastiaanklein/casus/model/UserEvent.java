package nl.sebastiaanklein.casus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserEvent {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private DoesAttend doesAttend;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "event_identifier")
	private	Event event;
	
	public UserEvent() {
		doesAttend = DoesAttend.UNDECIDED;
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


	@Override
	public String toString() {
		return "UserEvent [id=" + id + ", doesAttend=" + doesAttend + "]";
	}
	
	
	
	
}
