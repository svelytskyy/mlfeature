package com.forgerock.mlfeature.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.forgerock.mlfeature.exception.MLFeatureException;
import com.forgerock.mlfeature.exception.MLFeatureRuntimeException;
import com.forgerock.mlfeature.model.Input;
import com.forgerock.mlfeature.model.http.TransfResponse;
import com.forgerock.mlfeature.service.MLFeatureService;
import io.swagger.annotations.*;

@RestController
public class MLFeatureController {

	@Autowired MLFeatureService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MLFeatureController.class);
	
	@ApiParam(
			  value = "A JSON value representing a transaction.",
			  examples = @Example(value = 
			    @ExampleProperty(
			      mediaType = "application/json",
			      value = 
			    		  "'config': {" +
			    			   " 'id': '1', " +
			    			   " 'name': 'DeviceFeatures'," +
			    			   " 'transformations': [ " +
			    			   "   { " +
			    			   "     'name': 'device_os', " +
			    			   "     'useInML' : true, " +
			    			   "     'enabled' : true, " +
			    			   "     'jsltExpression': '.device.osType' " +
			    			   " }, " + 
			    			   " { " +
 			    			   "    'name': 'device_description', " +
			    			   "     'useInML' : true, " +
			    			   "     'enabled' : true, " +
			    			   "     'jsltExpression': '.device.osType + \" \" + .device.model' "+
			    			   " } " +
			    			   "] " +
			    			  "}, " +
			    			  " 'feature' : { " +
			    			  " 'eventId' : '878237843' , " +
			    			  "  'device': { " +
			    			  "    'osType': 'Linux', " +
			    			  "    'model': 'Laptop' " + 
			    			  "  }, " +
			    			  " 'ip' : '10.45.2.30', " +
			    			  " 'sessionId': 'ads79uoijd098098'" +
			    			  " } " +
			    			  " }"
			      		 
			      		  
			    )
			  )
			)
	
	@PostMapping(value="/transform", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public TransfResponse transform(@RequestBody Input input) {
		
		try {
			logger.debug("request : " + input.toJson(input).toPrettyString());
			
			Map<String, Object> payload = service.transform(input);
			TransfResponse resp = new TransfResponse("200", "Success");
			resp.setPayload(payload);
			
			logger.debug("response : " + resp.toJson(resp).toPrettyString());
			return resp;
		}catch(MLFeatureException e) {
			throw new MLFeatureRuntimeException(e);
		}
	
	}

}
