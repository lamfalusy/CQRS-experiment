package hu.lamsoft.experiment.cqrs.command.persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import hu.lamsoft.experiment.cqrs.command.persistence.accessor.UserAccessor;
import hu.lamsoft.experiment.cqrs.command.persistence.domain.User;

@Component
public class UserDao {

	@Autowired
	private MappingManager manager;
	
	private Mapper<User> mapper;
	
	private UserAccessor accessor;
	
	@PostConstruct
	private void init() {
		mapper = manager.mapper(User.class);
		accessor = manager.createAccessor(UserAccessor.class);
	}
	
	public List<User> findAll() {
		return accessor.findAll().all();
	}
	
}
