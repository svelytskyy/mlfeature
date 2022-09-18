package com.forgerock.mlfeature.exception;

public class MLFeatureRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	MLFeatureException e;

	public MLFeatureRuntimeException(MLFeatureException e) {
		super(e);
		this.e = e;
	}
	
	public MLFeatureRuntimeException(String message) {
		super(message);
	}

}
