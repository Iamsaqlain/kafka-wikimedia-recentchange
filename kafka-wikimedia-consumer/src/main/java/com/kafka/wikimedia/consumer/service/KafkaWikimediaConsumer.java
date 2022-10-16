package com.kafka.wikimedia.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.wikimedia.consumer.model.WikimediaData;
import com.kafka.wikimedia.consumer.repository.WikimediaDataRepository;

@Service
public class KafkaWikimediaConsumer {

	private static Logger logger = LoggerFactory.getLogger(KafkaWikimediaConsumer.class);
	
	@Autowired
	WikimediaDataRepository dataRepository;
	
	@KafkaListener(
			topics = "${topicName}",
			groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		logger.info("Event Message Received -> "+eventMessage);
		WikimediaData wikimediaData = new WikimediaData();
		dataRepository.save(wikimediaData);
	}
	
}
