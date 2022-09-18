package com.forgerock.mlfeature.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MLFeatureExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MLFeatureExceptionHandler.class);
	
	@ExceptionHandler(value = MLFeatureRuntimeException.class)
	public ResponseEntity<Object>exception(MLFeatureException exception){
		logger.error(exception.getMessage() + exception);
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
