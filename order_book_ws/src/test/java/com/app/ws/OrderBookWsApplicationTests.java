package com.app.ws;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.ws.bean.OrderBean;
import com.app.ws.service.OrderBookService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderBookWsApplicationTests {

	@Autowired
	OrderBookService service;
	
	
	@Test
	public void testCloseOrderBook() {
		
		System.out.println("Inside testCloseOrderBook");
		
		
		String resultneg = service.closeOrderBook("");
		Assert.assertEquals(resultneg, "Instrument Id should not be null");		
	}
	
	@Test
	public void testOpenOrderBook() {
		
		System.out.println("Inside testOpenOrderBook");
		
		

		String resultneg = service.openOrderBook("");
		Assert.assertEquals(resultneg, "Instrument Id should not be null");		
	}
	
	@Test
	public void testAddOrders() {
		
		System.out.println("Inside addOrders");
		
		
		OrderBean order =new OrderBean(UUID.randomUUID().toString(),"100",200
				,1000,new Date(),"MARKET");

		
		service.openOrderBook("100");
		
		String result = service.addOrderToOrderBook(order);
		Assert.assertEquals(result, "Order has been added");		
	}
	
	

}
