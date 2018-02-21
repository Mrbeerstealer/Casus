package nl.sebastiaanklein.casus.service;

import java.util.List;

import nl.sebastiaanklein.casus.model.DoesAttend;
import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.model.UserEvent;

public interface IUserEventService {
	public List<UserEvent> findAll();
	void create(UserEvent userEvent);
	UserEvent findByUserAndEvent(User user, Event event);
	void changeDoesAttend(UserEvent userEvent, DoesAttend doesAttend);
}
