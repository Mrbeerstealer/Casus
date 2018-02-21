package nl.sebastiaanklein.casus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.sebastiaanklein.casus.dao.IUserEventDAO;
import nl.sebastiaanklein.casus.model.DoesAttend;
import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.User;
import nl.sebastiaanklein.casus.model.UserEvent;

@Service
public class UserEventService implements IUserEventService{

	@Autowired
	private IUserEventDAO iUserEventDAO;
	
	@Override
	public List<UserEvent> findAll() {
		return this.iUserEventDAO.findAll();
	}

	@Override
	public void create(UserEvent userEvent) {
		this.iUserEventDAO.save(userEvent);
		
	}

	@Override
	public UserEvent findByUserAndEvent(User user, Event event) {
		return this.iUserEventDAO.findByUserAndEvent(user, event);
	}

	@Override
	public void changeDoesAttend(UserEvent userEvent, DoesAttend doesAttend) {
		userEvent.doesAttend(doesAttend);
		this.iUserEventDAO.save(userEvent);
	}

}
