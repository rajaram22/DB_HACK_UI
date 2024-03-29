package com.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.ws.model.response.ErrorMessage;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errorMsg = ex.getLocalizedMessage();
		
		ErrorMessage error = new ErrorMessage();
		error.setTimeStamp(new Date());
		error.setErrorMessage(errorMsg);
		
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
