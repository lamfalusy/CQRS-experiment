package hu.lamsoft.experiment.cqrs.command.persistence.domain;

import java.util.List;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "ts", name = "user")
public class User {

	@PartitionKey
	private Integer id;
	private String name;
	@Frozen
	private List<Task> tasks;
	
	public User() {
		// Nothing to do here
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
