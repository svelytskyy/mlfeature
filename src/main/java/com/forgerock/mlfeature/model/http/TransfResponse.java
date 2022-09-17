package com.forgerock.mlfeature.model.http;

import java.util.Map;

public class TransfResponse extends BaseResponse{
	private Map<String, Object> payload;

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	public TransfResponse() {}

	public TransfResponse(String code, String message) {
		super(code, message);
	}
	
	
	
}
