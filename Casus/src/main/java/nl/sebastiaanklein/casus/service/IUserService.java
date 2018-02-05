package nl.sebastiaanklein.casus.service;

import java.util.List;

import nl.sebastiaanklein.casus.model.User;

public interface IUserService {
	public List<User> findAll();
	public User findOne(Long id);
	void create(User user);
}
