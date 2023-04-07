package com.project.wallet;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@Configuration
public class WalletConfig {
	Properties getConsumerConfig()
	{
		Properties prop =new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		
		
		return prop;
		
	}
	@Bean
	ConsumerFactory<String,String> getProducerFactory(){
		return new DefaultKafkaConsumerFactory(getConsumerConfig());
	}
	
	
	


}
