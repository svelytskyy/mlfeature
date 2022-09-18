package com.forgerock.mlfeature.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forgerock.mlfeature.exception.MLFeatureException;
import com.forgerock.mlfeature.model.Input;

@Service
public class MLFeatureService {
	
	@Autowired MLFeatureProcessor processor;
	
	public Map<String, Object> transform(Input input) throws MLFeatureException{
		Map<String,Object> transformation = processor.transform(input);
		return transformation;
	}
	

}
