package nl.sebastiaanklein.casus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.sebastiaanklein.casus.dao.IUserEventDAO;
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

}
