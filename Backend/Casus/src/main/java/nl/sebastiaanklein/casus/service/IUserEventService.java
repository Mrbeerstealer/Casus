package nl.sebastiaanklein.casus.service;

import java.util.List;

import nl.sebastiaanklein.casus.model.UserEvent;

public interface IUserEventService {
	public List<UserEvent> findAll();
	void create(UserEvent userEvent);
}
