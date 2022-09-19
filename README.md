swagger - http://localhost:8080/mlfeature/api/swagger-ui.html


request :

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
	
Response :

{
    "code": "200",
    "payload": {
        "eventId": "878237843",
        "device_description": "Linux Laptop",
        "device_os": "Linux"
    },
    "meassage": "Success"
}



Autonomous Identity products need to extract features from free-form JSON objects for the purposes of analytics and machine learning.
Due to lack of a fixed schema, extracting features from JSON data needs to be declarative and configurable at run time. To help with simplifying the feature extraction, we use the JSON processing library which allows performing JSON transformations using a specific syntax - https://github.com/schibsted/jslt.
Analysts can define the JSLT transformations based on a specific JSON feed to be processed.
The goal of this exercise is to develop a microservice with REST API to retrieve ML features from a given JSON object
using a supplied feature configuration. Transformation would be defined using https://github.com/schibsted/jslt library. ● Feature configuration has
-- id
-- name
-- list of transform objects
● Each transform object has
-- name
-- enabled
-- useInML
-- jsltExpression
The microservice REST API should be able to accept feature configuration and JSON payload, process both and return transformed JSON output. Transforms which have "enabled" property set to false should not be included in the output. The feature configuration object and input JSON object may be different for each request.
For example:
Input FeatureConfig Object
{
"id": 1,
"name": "DeviceFeatures" "transforms": [
{
"name": "device_os",
"useInML" : true,
"enabled" : true, "jsltExpression": ".device.osType"
}, {
"name": "device_description",
"useInML" : true,
"enabled" : true,
"jsltExpression": ".device.osType + \" \" + .device.model"
} ]
}
 Input Json:
{
"eventId": "878237843" "device": {
"osType": "Linux",
"model": "Laptop", },
"ip" : "10.45.2.30",
"sessionId": "ads79uoijd098098" }
Output:
{
"eventId": "878237843",
"device_os": "Linux" , "device_description" : "Linux Laptop"
