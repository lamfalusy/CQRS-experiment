package hu.lamsoft.experiment.cqrs.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.experiment.cqrs.kafka.integration.producer.TestTopicProducer;
import hu.lamsoft.experiment.cqrs.kafka.service.IntegrationService;

@Service
public class IntegrationServiceImpl implements IntegrationService {
	
	@Autowired
	private TestTopicProducer testTopicProducer;

	@Override
	public void sendMessage(String message) {
		testTopicProducer.sendMessage(message);
	}

}
