package com.forgerock.mlfeature.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.forgerock.mlfeature.model.Input;
import com.forgerock.mlfeature.model.http.TransfResponse;
import com.forgerock.mlfeature.service.MLFeatureService;
import io.swagger.annotations.*;

@RestController
public class MLFeatureController {

	@Autowired MLFeatureService service;
	
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
		TransfResponse resp = new TransfResponse("200", "Success");
		Map<String, Object> payload = service.transform(input);
		resp.setPayload(payload);
		return resp;
	
	}

}
