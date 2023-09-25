package com.app.EPricingService.application.exceptionhandler;

public class PriceNotFoundException extends RuntimeException {
	
	public PriceNotFoundException(String message){
        super(message);
    }

}
