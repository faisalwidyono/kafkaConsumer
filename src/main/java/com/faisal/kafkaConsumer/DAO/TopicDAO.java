package com.faisal.kafkaConsumer.DAO;

import org.springframework.data.repository.CrudRepository;

import com.faisal.kafkaConsumer.model.TopicData;

public interface TopicDAO extends CrudRepository<TopicData, Long>{

}
