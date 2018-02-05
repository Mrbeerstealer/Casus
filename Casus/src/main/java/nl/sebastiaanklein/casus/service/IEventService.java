package nl.sebastiaanklein.casus.service;

import java.util.List;

import nl.sebastiaanklein.casus.model.Event;

public interface IEventService {
	public List<Event> findAll();
	public List<Event> findAllPublic();
	public Event findOne(Long id);
	void create(Event event);
}
