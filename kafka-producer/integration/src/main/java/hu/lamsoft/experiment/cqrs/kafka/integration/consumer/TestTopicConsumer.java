package hu.lamsoft.experiment.cqrs.kafka.integration.consumer;

import java.util.Arrays;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TestTopicConsumer {

	@Autowired
	private TaskExecutor taskExecutor;
	
	private Consumer<String, String> consumer;
	
	@PostConstruct
	private void init() {
		Properties props = new Properties();
	
		props.put("bootstrap.servers", "10.0.75.1:9092");
		props.put("group.id", "test-group");
		props.put("enable.auto.commit", "true");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("session.timeout.ms", "10000");
		props.put("fetch.min.bytes", "50000");
		props.put("receive.buffer.bytes", "262144");
		props.put("max.partition.fetch.bytes", "2097152");

		consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("fast-messages"));
		
		taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					printMessages();
				}
			}
			
		});
	}
	
	private void printMessages() {
		ConsumerRecords<String, String> records = consumer.poll(200);
		for (ConsumerRecord<String, String> record : records) {
			System.out.println(record.topic()+": "+record.value());
		}
	}
	
	@PreDestroy
	private void destroy() {
		consumer.close();
	}
	
}
