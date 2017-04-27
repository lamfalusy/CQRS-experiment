package hu.lamsoft.experiment.cqrs.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.cqrs.kafka.service.IntegrationService;

@RestController
public class DefaultRestController {

	@Autowired
	private IntegrationService integrationService;
	
	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public String sendMessage(@RequestBody String message) {
		integrationService.sendMessage(message);
		return message;
	}
	
}
