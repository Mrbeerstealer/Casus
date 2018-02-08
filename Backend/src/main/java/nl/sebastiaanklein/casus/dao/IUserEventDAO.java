package nl.sebastiaanklein.casus.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.sebastiaanklein.casus.model.UserEvent;

public interface IUserEventDAO extends CrudRepository<UserEvent, Long>{
	List<UserEvent> findAll();
}