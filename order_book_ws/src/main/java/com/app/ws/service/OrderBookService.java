package com.app.ws.service;

import com.app.ws.bean.ExecutionBean;
import com.app.ws.bean.OrderBean;

public interface OrderBookService {

	public String openOrderBook(String InstrumentId);

	public String closeOrderBook(String InstrumentId);

	public String addOrderToOrderBook(OrderBean order);

	public String addExecutionToOrderBook(ExecutionBean execution, String instrumentId);
}
