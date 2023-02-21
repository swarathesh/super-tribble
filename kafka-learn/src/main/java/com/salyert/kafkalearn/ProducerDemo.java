package com.salyert.kafkalearn;



import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {

	private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());


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

		//set Producer properties
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());


		//create a producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		//create a producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello world");

		//send data
		producer.send(record);

		//flush data
		producer.flush();

		//flush and close producer
		producer.close();






	}

}
