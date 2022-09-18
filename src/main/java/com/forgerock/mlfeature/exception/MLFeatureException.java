package com.forgerock.mlfeature.exception;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

import com.forgerock.mlfeature.model.http.BaseResponse;

public class MLFeatureException extends Exception{

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Exception e;
	private BaseResponse response;
	private HttpStatus httpstatus;
	private Logger logger;
	public MLFeatureException(String code, String message, Exception e, BaseResponse response, HttpStatus httpstatus,
			Logger logger) {
		super();
		this.code = code;
		this.message = message;
		this.e = e;
		this.response = response;
		this.httpstatus = httpstatus;
		this.logger = logger;
	}
	public MLFeatureException(String message) {
		super();
		this.message = message;
	}
	public MLFeatureException() {
		super();
	}

	public MLFeatureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public MLFeatureException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MLFeatureException(Throwable cause) {
		super(cause);
	}
	
	

}
