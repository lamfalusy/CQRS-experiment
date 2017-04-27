package hu.lamsoft.experiment.cqrs.kafka.service;

public interface IntegrationService {
	
	void sendMessage(String message);
	
}
