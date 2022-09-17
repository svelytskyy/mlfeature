package com.forgerock.mlfeature.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseInput {
	
	public JsonNode toJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(object, JsonNode.class);
	}

}
