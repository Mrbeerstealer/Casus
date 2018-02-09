package nl.sebastiaanklein.casus.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.sebastiaanklein.casus.model.User;

public interface IUserDAO extends CrudRepository<User, Long> {
	List<User> findAll();
	
	User findOne(Long id);
}
