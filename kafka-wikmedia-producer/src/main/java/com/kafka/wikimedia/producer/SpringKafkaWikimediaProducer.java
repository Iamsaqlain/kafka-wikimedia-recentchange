package com.kafka.wikimedia.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.wikimedia.producer.service.KafkaWikimediaProducer;

@SpringBootApplication
public class SpringKafkaWikimediaProducer implements CommandLineRunner{

	@Autowired
	private KafkaWikimediaProducer wikimediaProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaWikimediaProducer.class);
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaProducer.sendMessage();
	}
}
