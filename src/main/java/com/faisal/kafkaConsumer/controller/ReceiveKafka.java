package com.faisal.kafkaConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.faisal.kafkaConsumer.DAO.TopicDAO;
import com.faisal.kafkaConsumer.model.TopicData;

@Service
public class ReceiveKafka {
	private String topic ="faisal";
	@Autowired
	TopicDAO topicDAO;
	
	@KafkaListener(topics = "faisal", groupId = "group.id=test-consumer-group")
	public TopicData listen(String message) {
		System.out.println("Received Message in group Test: "+message);
		if (message !=null) {
			TopicData topicData = new TopicData();
			topicData.setTopic_name(topic);
			topicData.setData(message);
					
			return topicDAO.save(topicData);
				
			}else {
				return null;
			}
	}

}
