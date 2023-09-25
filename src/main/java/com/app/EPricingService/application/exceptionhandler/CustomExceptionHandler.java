package com.app.EPricingService.application.exceptionhandler;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.EPricingService.application.dto.ErrorResponse;


@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePriceNotFoundException(PriceNotFoundException ex) {
	    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}

