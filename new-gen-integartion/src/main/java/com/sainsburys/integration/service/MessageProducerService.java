package com.sainsburys.integration.service;

import java.util.Properties;

import org.springframework.stereotype.Service;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsburys.integration.controllers.IntegrationController;
import com.sainsburys.integration.models.Order;
import com.sainsburys.integration.utility.CustomSerializer;

@Service
public class MessageProducerService {
	 private static final Logger LOG = LoggerFactory.getLogger(MessageProducerService.class);
	public final String TOPIC_NAME = "test";

	public void postItemsToMessageBus(Order order) {
		Producer<String, Order> producer = null;
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		//props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
		try {
			producer = new KafkaProducer<String, Order>(props);
			ProducerCallback callback = new ProducerCallback();
			ProducerRecord<String, Order> data = new ProducerRecord<String, Order>(TOPIC_NAME, "KEY", order);
			producer.send(data, callback);
		} catch (Exception exp) {
			LOG.error(exp.getMessage());
			System.out.println(exp.getMessage());
		} finally {
			if (producer != null)
				producer.close();
		}
		
		
	}
}

class ProducerCallback implements Callback {
	@Override
	public void onCompletion(RecordMetadata recordMetadata, Exception e) {
		if (e != null) {
			System.out.println("Error while producing message to topic :" + recordMetadata);
			e.printStackTrace();
		} else {
			String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(),
					recordMetadata.partition(), recordMetadata.offset());
			System.out.println(message);
		}
	}

}
