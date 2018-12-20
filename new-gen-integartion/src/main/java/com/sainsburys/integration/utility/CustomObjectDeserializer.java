package com.sainsburys.integration.utility;

import java.util.List;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sainsburys.integration.models.*;

public class CustomObjectDeserializer implements Deserializer<List<Order>> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public List<Order> deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		List<Order> object = null;
		try {
			List<Order> value = mapper.readValue(data, new TypeReference<List<Order>>() {
			});
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}