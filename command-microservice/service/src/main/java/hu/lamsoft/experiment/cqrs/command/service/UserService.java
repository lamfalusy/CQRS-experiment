package hu.lamsoft.experiment.cqrs.command.service;

import java.util.List;

import hu.lamsoft.experiment.cqrs.command.persistence.domain.User;

public interface UserService {

	List<User> getUsers();
	
}
