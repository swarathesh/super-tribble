package com.salyert.kafkalearn;



import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoCallbackKeys {

	private static final Logger log = LoggerFactory.getLogger(ProducerDemoCallbackKeys.class.getSimpleName());


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

		//array has 10000 random quotes
		String[] quotes = {"The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn.","The greatest glory in living lies not in never falling, but in rising every time we fall.",
				"The way to get started is to quit talking and begin doing.",
				"If life were predictable it would cease to be life, and be without flavor.",
				"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
				"Life is what happens when you're busy making other plans.",
				"Spread love everywhere you go. Let no one ever come to you without leaving happier.",
				"When you reach the end of your rope, tie a knot in it and hang on.",
				"Always remember that you are absolutely unique. Just like everyone else.",
				"The future belongs to those who believe in the beauty of their dreams.",
				"Tell me and I forget. Teach me and I remember. Involve me and I learn."};


	
				
		//create a for loop to send 10 random quotes
		for(String quote : quotes) {
         

			String key = "id_" + quote;

		


			//create a producer record
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic",key, quote);

			//send data
			producer.send(record, new Callback() {
				
				@Override
				public void onCompletion(org.apache.kafka.clients.producer.RecordMetadata metadata, Exception exception) {
					//executes every time a record is successfully sent or an exception is thrown
					if (exception == null) {
						log.info("Received new metadata. \n" +
								"Topic: " + metadata.topic() + "\n" +
								"Partition: " + metadata.partition() + "\n" +
								"Offset: " + metadata.offset() + "\n" +
								"Timestamp: " + metadata.timestamp());
					} else {
						log.error("Error while producing", exception);
					}
				}
			});
		}

		
		//flush data
		producer.flush();

		//flush and close producer
		producer.close();






	}

}
