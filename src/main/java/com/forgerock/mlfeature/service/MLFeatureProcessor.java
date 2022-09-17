package com.forgerock.mlfeature.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.forgerock.mlfeature.model.Input;
import com.forgerock.mlfeature.model.Transformation;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

@Component
public class MLFeatureProcessor {
	
	public Map<String, Object> transform(Input input) {
		JsonNode jsonFeature = input.getFeature().toJson(input.getFeature());
		Map<String,Object> result = new HashMap<>();
		for(Transformation transformation : input.getConfig().getTransformations()) {
			if(transformation.isEnabled()) {
				Expression jslt = Parser.compileString(transformation.getJsltExpression());
				JsonNode node = jslt.apply(jsonFeature);
				result.put(transformation.getName(), node);
			}
		}
		result.put("eventId", input.getFeature().getEventId());
		return result;
	}

}
