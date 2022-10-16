package com.kafka.wikimedia.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.wikimedia.consumer.model.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
