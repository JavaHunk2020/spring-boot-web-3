package com.it.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.it.dto.EmailMessageDTO;

@Configuration
public class KafkaConfiguration {
	
	@Value(value = "${bootstrap.servers}")
	private String bootstrapAddress;
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public ProducerFactory<String, EmailMessageDTO> producerFactory() {
		Map<String, Object> props = new HashMap<>(); // localhost:9092
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(props);
	}
	
	@Bean
	public KafkaTemplate<String, EmailMessageDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
