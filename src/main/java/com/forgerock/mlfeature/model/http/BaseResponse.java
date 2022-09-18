package com.forgerock.mlfeature.model.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseResponse {
	
	public BaseResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public BaseResponse() {}

	private String code;
	private String message;
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMeassage() {
		return message;
	}

	public void setMeassage(String meassage) {
		this.message = meassage;
	}

	@Override
	public String toString() {
		return "BaseResponse [code=" + code + ", message=" + message + "]";
	}
	
	public JsonNode toJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(object, JsonNode.class);
	}


}
