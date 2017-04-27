package hu.lamsoft.experiment.cqrs.kafka.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
public class IntegrationConfiguration {

	@Bean
	public TaskExecutor taskExecutor() {
	    return new SimpleAsyncTaskExecutor();
	}
	
}
