package com.salyert.kafkalearn;



import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo {

	private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class.getSimpleName());


	public static void main(String[] args) {
		
		//create a producer properties
		Properties properties = new Properties();

		//connect to local kafka server
		// properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        //connect to conduktor bootstrap server
		properties.setProperty("bootstrap.servers", "cluster.playground.cdkt.io:9092");


		properties.setProperty("security.protocol", "SASL_SSL");
		properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"ETYQCGjD0lSKjBHftDo5R\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiJFVFlRQ0dqRDBsU0tqQkhmdERvNVIiLCJvcmdhbml6YXRpb25JZCI6NzAwODUsInVzZXJJZCI6ODEwMjgsImZvckV4cGlyYXRpb25DaGVjayI6IjM4NmNjNDI5LTBiYWQtNDA3OS1iZGU1LTc1OGVmYWVlMjYyYiJ9fQ.PAsFKY6pE5LKh1gmwYeebIneicdnKTkLe514oWojk1w\";");
		properties.setProperty("sasl.mechanism", "PLAIN");

		properties.setProperty("key.deserializer", StringDeserializer.class.getName());
		properties.setProperty("value.deserializer", StringDeserializer.class.getName());
		properties.setProperty("group.id", "my-first-application");
		properties.setProperty("auto.offset.reset", "latest");

		//create a consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);


		//subscribe to a topic
		consumer.subscribe(Arrays.asList("first_topic"));

		while(true) {
		
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

			for(ConsumerRecord<String,String> record : records) {
				log.info("Key: " + record.key() + ", Value: " + record.value());
				log.info("Partition: " + record.partition() + ", Offset: " + record.offset());
			}
		}





	}

}
