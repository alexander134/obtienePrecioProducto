package com.app.EPricingService.exception;

public class PriceNotFoundException extends RuntimeException {
	
	public PriceNotFoundException(String message){
        super(message);
    }

}
