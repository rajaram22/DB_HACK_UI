package com.app.ws.model.response;

import java.util.Date;

public class ErrorMessage {
	
	private String errorMessage;
	private Date timeStamp;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
