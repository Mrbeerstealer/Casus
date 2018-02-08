package nl.sebastiaanklein.casus.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.sebastiaanklein.casus.model.Event;

public interface IEventDAO extends CrudRepository<Event, Long>{
	List<Event> findAll();
}