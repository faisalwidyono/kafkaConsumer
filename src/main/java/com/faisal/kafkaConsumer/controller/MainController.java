package com.faisal.kafkaConsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.faisal.kafkaConsumer.DAO.TopicDAO;
import com.faisal.kafkaConsumer.model.TopicData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Consumer")
@RestController
@RequestMapping(value = "api/v1")
public class MainController {
	@Autowired
	TopicDAO topicDAO;
	
	@ApiOperation(
			value = "API to publish data",
		    notes = "Get All Consumer data on Database",
		    tags = "Get All Data"
			)
	@GetMapping("/getAllTopic")
	public List<TopicData> getAllTopic() {
		return (List<TopicData>) topicDAO.findAll();
		
	}
	
	@ApiOperation(
			value = "API to publish data",
		    notes = "Delete Consumer data on Database",
		    tags = "Deleteh Data"
			)
	@DeleteMapping("/deleteTopic/{id}")
	public String delete(@PathVariable Long id) {
		topicDAO.deleteById(id);
		return "Data ID= " +(id)+" Berhasil Dihapus";
	}
	
	@ApiOperation(
			value = "API to publish data",
		    notes = "Update Consumer data on Database",
		    tags = "Update Data"
			)
	@PutMapping("updateTopic/{id}")
	public TopicData updateTopic(@RequestBody TopicData topicData, @PathVariable Long id) {
		
		TopicData topicSelected = topicDAO.findById(id).orElse(null);
		
		if (topicSelected !=null) {
			topicSelected.setTopic_name(topicData.getTopic_name());
			topicSelected.setData(topicData.getData());
						
			return topicDAO.save(topicSelected);
		}else {
			return null;
		}
	}
	

}
