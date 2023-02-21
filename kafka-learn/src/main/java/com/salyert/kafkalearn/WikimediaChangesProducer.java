package com.salyert.kafkalearn;



import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;;

public class WikimediaChangesProducer{


    public static void main(String[] args)  {

        String bootstrapServers = "cluster.playground.cdkt.io:9092";

        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty("security.protocol", "SASL_SSL");
		properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"ETYQCGjD0lSKjBHftDo5R\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiJFVFlRQ0dqRDBsU0tqQkhmdERvNVIiLCJvcmdhbml6YXRpb25JZCI6NzAwODUsInVzZXJJZCI6ODEwMjgsImZvckV4cGlyYXRpb25DaGVjayI6IjM4NmNjNDI5LTBiYWQtNDA3OS1iZGU1LTc1OGVmYWVlMjYyYiJ9fQ.PAsFKY6pE5LKh1gmwYeebIneicdnKTkLe514oWojk1w\";");
		properties.setProperty("sasl.mechanism", "PLAIN");

        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        

         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

         String topic = "first_topic";

         BackgroundEventHandler eventHandler ;

         String url = "https://stream.wikimedia.org/v2/stream/recentchange";


         BackgroundEventHandler myHandler = new WikimediaChangeHandler(producer, topic);

          BackgroundEventSource bes = new BackgroundEventSource.Builder(myHandler,
              new EventSource.Builder(
                ConnectStrategy.http(URI.create(url))
                  .connectTimeout(5, TimeUnit.SECONDS)
                  // connectTimeout and other HTTP options are now set through
                  // HttpConnectStrategy
                )
            )
            .threadPriority(Thread.MAX_PRIORITY)
              // threadPriority, and other options related to worker threads,
              // are now properties of BackgroundEventSource
            .build();


          bes.start();
          
          //produce for 10 mins and block the program  until then
          try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}