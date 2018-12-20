package com.sainsburys.integration.utility;
import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sainsburys.integration.models.*;

public class CustomSerializer implements Serializer<Order> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }
    
    @Override
    public byte[] serialize(String topic, Order data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
        	System.out.println("Error in serializing object"+ data);
        }
        return retVal;
    }
    @Override
    public void close() {
    }
}