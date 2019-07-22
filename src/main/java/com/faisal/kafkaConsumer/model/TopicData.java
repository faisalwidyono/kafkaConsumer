package com.faisal.kafkaConsumer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString(callSuper = true)
@Entity
@Table(name="topic")
public class TopicData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_topic")
	private Long id;
	
	@Column(nullable = false, name = "topic")
	private String topic_name;
	
	@Column(nullable = false)
	private String data;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name = "modified_at")
	@Temporal(TemporalType.DATE)
	private Date modifiedAt;

}
