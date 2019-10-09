package com.app.ws.model.request;

import java.util.Date;

public class OrderFormBean {
	
	private String instrumentId;
	private double orderQuantity;
	private double price;
	private String orderType;
	
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	public double getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	

	
	

}
