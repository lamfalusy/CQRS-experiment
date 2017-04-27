package hu.lamsoft.experiment.cqrs.kafka.integration.producer;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

@Component
public class TestTopicProducer {

	private Producer<String, String> producer;
	
	@PostConstruct
	private void init() {
		Properties props = new Properties();
		
		props.put("bootstrap.servers", "10.0.75.1:9092");
		props.put("acks", "all");
		props.put("retries", "0");
		props.put("batch.size", "16384");
		props.put("auto.commit.interval.ms", "1000");
		props.put("linger.ms", "0");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("block.on.buffer.full", "true");

		producer = new KafkaProducer<>(props);
	}
	
	@PreDestroy
	private void destroy() {
		producer.close();
	}
	
	public void sendMessage(String message) {
		producer.send(new ProducerRecord<String, String>("fast-messages", message));
	}
	
}
