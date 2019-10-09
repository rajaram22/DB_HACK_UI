package com.app.ws.bean;

import java.util.Date;

public final class OrderBean {

	private String orderId;
	private String instrumentId;
	private double orderQuantity;
	private double price;
	private Date orderDate;
	private String orderType;
	
	public OrderBean(String orderId, String instrumentId, double orderQuantity, double price, Date orderDate,
			String orderType) {
		super();
		this.orderId = orderId;
		this.instrumentId = instrumentId;
		this.orderQuantity = orderQuantity;
		this.price = price;
		this.orderDate = orderDate;
		this.orderType = orderType;
	}
	public String getOrderId() {
		return orderId;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public double getPrice() {
		return price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getOrderType() {
		return orderType;
	}
	
	
	
	
	
}
