package com.sainsburys.integration.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.sainsburys.integration.data.OrderDAOImpl;
import com.sainsburys.integration.models.Order;


@Service
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    @Autowired
    public OrderDAOImpl orderDAOImpl;

    @KafkaListener(topics = "test")
    public void listen(@Payload Order order) {
    	System.out.println("received message='{}'"+ order);
        LOG.info("received message='{}'", order);
        orderDAOImpl.create(order);
    }

}
