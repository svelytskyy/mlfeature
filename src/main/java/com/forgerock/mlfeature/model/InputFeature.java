package com.forgerock.mlfeature.model;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InputFeature extends BaseInput{
	
	private String eventId;
	private Map<String,Object> device;
	private String ip;
	private String sessionId;
	
	public InputFeature(String eventId, Map<String, Object> device, String ip, String sessionId) {
		super();
		this.eventId = eventId;
		this.device = device;
		this.ip = ip;
		this.sessionId = sessionId;
	}
	public InputFeature() {
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public Map<String, Object> getDevice() {
		return device;
	}
	public void setDevice(Map<String, Object> device) {
		this.device = device;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "InputFeature [eventId=" + eventId + ", device=" + device + ", ip=" + ip + ", sessionId=" + sessionId
				+ "]";
	}
	
}
