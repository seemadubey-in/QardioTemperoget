package com.qardio.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.qardio.db.TemperatureDataService;
import com.qardio.model.Temperature;

@Component
public class KafkaConsumer {
		
	@Autowired
	TemperatureDataService tempService;
	
	@KafkaListener(topics = "QardioTopic", groupId = "group_json",containerFactory = "tempKafkaListenerFactory")
	public void consume(Temperature temp){
		System.out.println("message = " + temp);
		
		tempService.saveTempDataFromQue(temp);
	}
}
