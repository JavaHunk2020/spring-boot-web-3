package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.it.dto.EmailMessageDTO;
import com.it.repository.entity.Signup;

@Service
public class KafkaSenderService {
	
	@Autowired
	KafkaTemplate<String,EmailMessageDTO>  kafkaTemplate; 
	
	@Value(value = "${email.topic.name}")
	private String emailTopicName;

	public void sendMessage(Signup signup) {
		// Code to send message on apache Kafka
		EmailMessageDTO emailMessageDTO = new EmailMessageDTO();
		emailMessageDTO.setToEmail(signup.getEmail());
		emailMessageDTO.setSubject("Regarding customer signup");
		emailMessageDTO.setUsername(signup.getUsername());
		kafkaTemplate.send(emailTopicName, emailMessageDTO);
	}

}
