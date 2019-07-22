package com.faisal.kafkaConsumer.connection;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.errors.GroupIdNotFoundException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@EnableKafka
@Configuration
public class KafkaConnection {
private String address = "localhost:9092";
private String group= "group.id=test-consumer-group";
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(
				ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				address);
		configProps.put(
				ConsumerConfig.GROUP_ID_CONFIG,
				group);
		configProps.put(
				ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		configProps.put(
				ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
				
				return new DefaultKafkaConsumerFactory<>(configProps);
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String>
		kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory
		= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
