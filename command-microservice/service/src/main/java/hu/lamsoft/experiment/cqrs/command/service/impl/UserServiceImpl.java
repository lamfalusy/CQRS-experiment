package hu.lamsoft.experiment.cqrs.command.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.experiment.cqrs.command.persistence.dao.UserDao;
import hu.lamsoft.experiment.cqrs.command.persistence.domain.User;
import hu.lamsoft.experiment.cqrs.command.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

}
