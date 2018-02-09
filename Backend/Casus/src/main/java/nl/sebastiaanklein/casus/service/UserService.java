package nl.sebastiaanklein.casus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.sebastiaanklein.casus.dao.IUserDAO;
import nl.sebastiaanklein.casus.model.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDAO iUserDAO;
	
	@Override
	public List<User> findAll() {
		return this.iUserDAO.findAll();
	}
	
	@Override
	public User findOne(Long id) {
		System.out.println(this.iUserDAO.findOne(id).toString());
		return this.iUserDAO.findOne(id);
	}

	@Override
	public void create(User user) {
		this.iUserDAO.save(user);	
	}

}
