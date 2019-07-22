package com.faisal.kafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.faisal.kafkaConsumer.DAO.TopicDAO;
import com.faisal.kafkaConsumer.connection.KafkaConnection;
import com.faisal.kafkaConsumer.model.TopicData;

@Service
public class ReceiveKafka {
	@Autowired
	TopicDAO topicDAO;

	
	
	@KafkaListener(topics = "faisal", groupId = "group.id=test-consumer-group")
	public TopicData listen(String message) {
		System.out.println("Received Message in group Test: "+message);
		if (message !=null) {
			TopicData topicData = new TopicData();
			topicData.setData(message);
					
			return topicDAO.save(topicData);
				
			}else {
				return null;
			}
	}

}
