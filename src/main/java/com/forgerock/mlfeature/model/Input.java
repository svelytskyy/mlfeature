package com.forgerock.mlfeature.model;

/*
{
	  "config": {
	    "id": "1",
	    "name": "DeviceFeatures",
	    "transformations": [
	      {
	        "name": "device_os",
	        "useInML" : true,
	        "enabled" : true, 
	        "jsltExpression": ".device.osType"
	    }, 
	    {
	        "name": "device_description",
	        "useInML" : true,
	        "enabled" : true,
	        "jsltExpression": ".device.osType + \" \" + .device.model"
	    }
	    ]
	  },
	  "feature" : {
	  	"eventId": "878237843",
	    "device": {
	      "osType": "Linux",
	      "model": "Laptop" 
	    },
	    "ip" : "10.45.2.30",
		"sessionId": "ads79uoijd098098"
	  }
	}
	*/
public class Input extends BaseInput{
	
	private InputFeatureConfig config;
	private InputFeature feature;
	
	public Input() {}

	public InputFeatureConfig getConfig() {
		return config;
	}

	public void setConfig(InputFeatureConfig config) {
		this.config = config;
	}

	public InputFeature getFeature() {
		return feature;
	}

	public void setFeature(InputFeature feature) {
		this.feature = feature;
	}
	
}
