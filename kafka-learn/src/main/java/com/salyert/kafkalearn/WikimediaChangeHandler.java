package com.salyert.kafkalearn;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;

public class WikimediaChangeHandler implements BackgroundEventHandler {


    KafkaProducer<String, String> producer;
    String topic;

    //create Logger for class
    private static Logger logger = LoggerFactory.getLogger(WikimediaChangeHandler.class);

    // Constructor
    public WikimediaChangeHandler(KafkaProducer<String, String> producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onClosed() throws Exception {
        this.producer.close();

    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
        logger.info("Received message: " + messageEvent.getData());
        this.producer.send(new ProducerRecord<String, String>(this.topic, messageEvent.getData()));
        
    }

    @Override
    public void onComment(String comment) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onError(Throwable t) {
        //Log error
        logger.error("Error: " + t.getMessage());
        
    }
    
}
