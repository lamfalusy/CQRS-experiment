package hu.lamsoft.experiment.cqrs.command.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.mapping.MappingManager;

@Configuration
public class PersistenceConfiguration {

	@Value("${cassandra.node}")
	private String node;

	@Value("${cassandra.port}")
	private int port;
	
	@Bean
	public MappingManager mappingManager() {
		Builder b = Cluster.builder().addContactPoint(node);
		b.withPort(port);
		return new MappingManager(b.build().connect());
	}
	
}
