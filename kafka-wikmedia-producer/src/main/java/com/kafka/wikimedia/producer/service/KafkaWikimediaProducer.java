package com.kafka.wikimedia.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class KafkaWikimediaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	@Value("${topicName}")
	private String topicName;
	
	@Value("${apiURL}")
	private String wikimediaURL;
	
	public void sendMessage() throws InterruptedException {
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate,topicName);
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(wikimediaURL));
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(1);
	}
}
