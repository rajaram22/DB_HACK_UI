package com.app.ws.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.ws.bean.ExecutionBean;
import com.app.ws.bean.OrderBean;
import com.app.ws.model.request.ExecutionFormBean;
import com.app.ws.model.request.OrderFormBean;
import com.app.ws.model.response.ResponseMessage;
import com.app.ws.service.OrderBookService;

@RestController
@RequestMapping(value = "/orderBook")
public class OrderBookController {

	@Autowired
	OrderBookService orderBookService;

	@RequestMapping(method = RequestMethod.POST, value = "/addOrderToOrderBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage addOrderToOrderBook(@RequestBody OrderFormBean orderForm) {

		OrderBean order = new OrderBean(UUID.randomUUID().toString(), orderForm.getInstrumentId(),
				orderForm.getOrderQuantity(), orderForm.getPrice(), new Date(), orderForm.getOrderType());

		String responseMsg = orderBookService.addOrderToOrderBook(order);

		ResponseMessage response = new ResponseMessage();

		response.setResponseMessage(responseMsg);

		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/openOrderBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage openOrderBook(@RequestBody OrderFormBean orderForm) {

		String responseMsg = orderBookService.openOrderBook(orderForm.getInstrumentId());

		ResponseMessage response = new ResponseMessage();

		response.setResponseMessage(responseMsg);

		return response;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/closeOrderBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage closeOrderBook(@RequestBody OrderFormBean orderForm) {

		String responseMsg = orderBookService.closeOrderBook(orderForm.getInstrumentId());

		ResponseMessage response = new ResponseMessage();

		response.setResponseMessage(responseMsg);

		return response;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/executeOrderBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage executeOrderBook(@RequestBody ExecutionFormBean executionForm) {

		
		ExecutionBean execution = new ExecutionBean();
		execution.setPrice(executionForm.getPrice());
		execution.setQuantity(executionForm.getQuantity());
		
		String responseMsg = orderBookService.addExecutionToOrderBook(execution, executionForm.getInstrumentId());

		ResponseMessage response = new ResponseMessage();

		response.setResponseMessage(responseMsg);

		return response;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/check")
	public String checkMessage() {

		




		return "Hello Rajaram !";
	}
}
