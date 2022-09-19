package com.forgerock.mlfeature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.node.TextNode;
import com.forgerock.mlfeature.controller.MLFeatureController;
import com.forgerock.mlfeature.model.Input;
import com.forgerock.mlfeature.model.InputFeature;
import com.forgerock.mlfeature.model.InputFeatureConfig;
import com.forgerock.mlfeature.model.Transformation;
import com.forgerock.mlfeature.service.MLFeatureService;

@SpringBootTest
class MLFeatureApplicationTests {
	
	@Autowired private MLFeatureController controller;
	@Autowired MLFeatureService service;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}
	
	@Test
	void testCase1() throws Exception{
		Input input = initInputCase1();
		
		Map<String, Object>  map = service.transform(input);
		//assertTrue(map.containsKey("device_description"));
		TextNode value = (TextNode)map.get("device_description");
		assertTrue(value.asText().equals("Linux Laptop"));
	}
	
	private Input initInputCase1() {
		Input input = new Input();
		InputFeatureConfig config = new InputFeatureConfig();
		config.setId("1");
		config.setName("DeviceFeatures");
		List<Transformation> list = Stream.of(new Transformation("device_os",true, true, ".device.osType"),
											  new Transformation("device_description",true, true, ".device.osType + \" \" + .device.model")			).collect(Collectors.toList());
		
		config.setTransformations(list);
		InputFeature feature = new InputFeature("878237843", Map.of("osType","Linux","model","Laptop"),"10.45.2.30", "ads79uoijd098098");
		input.setConfig(config);
		input.setFeature(feature);
		return input;
	}

}
