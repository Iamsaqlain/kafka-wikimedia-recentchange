package com.kafka.wikimedia.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler{

	private static Logger logger =  LoggerFactory.getLogger(WikimediaChangesHandler.class);

	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${topicName}")
	private String topicName;

	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
		this.kafkaTemplate = kafkaTemplate;
		this.topicName = topicName;
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComment(String arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String s, MessageEvent eventMessage) throws Exception {
		logger.info("Event Message -> "+eventMessage.getData());
		kafkaTemplate.send(topicName,eventMessage.getData());
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
