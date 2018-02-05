package nl.sebastiaanklein.casus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.sebastiaanklein.casus.dao.IEventDAO;
import nl.sebastiaanklein.casus.model.Event;
import nl.sebastiaanklein.casus.model.EventType;

@Service
public class EventService implements IEventService{

	@Autowired
	private IEventDAO iEventDAO;
	
	@Override
	public List<Event> findAll() {
		return this.iEventDAO.findAll();
	}
	
	@Override
	public List<Event> findAllPublic() {
		List<Event> eventList = this.iEventDAO.findAll();
		for(int i = 0; i<eventList.size();i++) {
			if(eventList.get(i).getEventType().equals(EventType.PRIVATE_PARTY)) {
				eventList.remove(i);
			}
		}
		return eventList;
	}
	
	@Override
	public Event findOne(Long id) {
		return this.iEventDAO.findOne(id);
	}

	@Override
	public void create(Event event) {
		this.iEventDAO.save(event);
		
	}

}
