package hu.lamsoft.experiment.cqrs.command.persistence.domain;

import java.util.Date;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "ts", name = "task")
public class Task {

	@Field(name = "created_time")
	private Date createdTime;
	private String description;
	
	public Task() {
		// Nothing to do here
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
