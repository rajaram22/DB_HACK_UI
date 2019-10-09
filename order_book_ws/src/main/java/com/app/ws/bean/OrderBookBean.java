package com.app.ws.bean;

import java.util.List;

public class OrderBookBean {

	private String instrumentId;
	private String status;
	private List<OrderBean> orderList;
	private ExecutionBean execution;
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}
	public ExecutionBean getExecution() {
		return execution;
	}
	public void setExecution(ExecutionBean execution) {
		this.execution = execution;
	}
	
	
	
}
