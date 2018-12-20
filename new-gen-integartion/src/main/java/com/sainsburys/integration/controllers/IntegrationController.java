package com.sainsburys.integration.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sainsburys.integration.consumer.Receiver;
import com.sainsburys.integration.models.Order;
import com.sainsburys.integration.service.*;




@RestController
public class IntegrationController {
	 private static final Logger LOG = LoggerFactory.getLogger(IntegrationController.class);
	@Autowired
	public MessageProducerService service;
	@Autowired
	public ReadOrderService readOrderService;
	
	
    @RequestMapping(value="/integration" ,method = RequestMethod.POST)
	public String postItemDetails(@RequestBody Order order) {
    	System.out.println("Inside controller");
    	service.postItemsToMessageBus(order);
    	return "OK-Pass";
    	
	}
    
    @RequestMapping(value="/processOrders" ,method = RequestMethod.GET)
   	public String processOrders() {
    	System.out.println("processOrders inside controller");
    	List<Order> orders = readOrderService.readOrdersFromFile();
    	for(Order order :orders) {
    		service.postItemsToMessageBus(order);
    	}
       	return "OK";
   	}
    
}
