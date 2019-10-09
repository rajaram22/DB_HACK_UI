package com.app.ws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.ws.bean.ExecutionBean;
import com.app.ws.bean.OrderBean;
import com.app.ws.bean.OrderBookBean;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	Map<String, OrderBookBean> orderBookList = new HashMap<String, OrderBookBean>();

	@Override
	public String openOrderBook(String instrumentId) {

		String result = null;

		if (!StringUtils.isEmpty(instrumentId)) {

			if (!orderBookList.containsKey(instrumentId)) {

				OrderBookBean orderBook = new OrderBookBean();
				orderBook.setInstrumentId(instrumentId);
				orderBook.setStatus("OPEN");
				List<OrderBean> orderList = new ArrayList<OrderBean>();
				orderBook.setOrderList(orderList);
				orderBookList.put(instrumentId, orderBook);
				result = "Order Book has been opened";

			} else {
				System.out.println("Order Book is already open for the given InstrumentId");
				result = "Order Book is already open";
			}

		} else {
			System.out.println("Instrument Id should not be null");
			result = "Instrument Id should not be null";
		}

		return result;

	}

	@Override
	public String closeOrderBook(String instrumentId) {

		String result = null;

		if (!StringUtils.isEmpty(instrumentId)) {

			if (orderBookList.containsKey(instrumentId)) {

				OrderBookBean orderBook = orderBookList.get(instrumentId);
				if ("OPEN".equalsIgnoreCase(orderBook.getStatus())) {
					orderBook.setStatus("CLOSED");
					orderBookList.put(instrumentId, orderBook);
					result = "Order Book has been closed";
				} else {
					result = "Order Book is already closed";
				}
			} else {
				System.out.println("Order Book is already closed for the given InstrumentId");
				result = "Order Book is already closed";
			}

		} else {
			System.out.println("Instrument Id should not be null");
			result = "Instrument Id should not be null";
		}

		return result;

	}

	@Override
	public String addOrderToOrderBook(OrderBean order) {

		String result = null;

		String instrumentId = order.getInstrumentId();

		if (!StringUtils.isEmpty(instrumentId)) {

			if (orderBookList.containsKey(instrumentId)) {

				OrderBookBean orderBook = orderBookList.get(instrumentId);
				if ("OPEN".equalsIgnoreCase(orderBook.getStatus())) {

					orderBook.getOrderList().add(order);
					result = "Order has been added";
				} else {
					System.out.println("Order cannot be added");
					result = "Order cannot be added";
				}

			}else {
				result = "OrderBook is not open for the given Instrument Id";
			}

		} else {

			System.out.println("Instrument Id should not be null");
			result = "Instrument Id should not be null";
		}
		return result;
	}

	@Override
	public String addExecutionToOrderBook(ExecutionBean execution, String instrumentId) {

		String result = null;

		if (!StringUtils.isEmpty(instrumentId)) {

			if (orderBookList.containsKey(instrumentId)) {

				OrderBookBean orderBook = orderBookList.get(instrumentId);
				if ("CLOSED".equalsIgnoreCase(orderBook.getStatus()) && orderBook.getExecution() != null) {

					orderBook.setExecution(execution);
					result = "Execution has been added";
				} else {
					System.out.println("Execution cannot be added");
					result = "Execution cannot be added";
				}

			} else {
				result = "Instrument ID is not available";
			}

		} else {

			System.out.println("Instrument Id should not be null");
			result = "Instrument Id should not be null";
		}
		return result;
	}

}
