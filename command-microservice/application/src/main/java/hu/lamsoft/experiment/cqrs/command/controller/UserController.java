package hu.lamsoft.experiment.cqrs.command.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.cqrs.command.persistence.domain.User;
import hu.lamsoft.experiment.cqrs.command.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
}
