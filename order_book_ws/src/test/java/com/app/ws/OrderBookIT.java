package com.app.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderBookWsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderBookIT {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders header = new HttpHeaders();
	
	@Test
	public void testOrder() {
		
		System.out.println("Inside testOrder IT testing");
		HttpEntity<String> httpEntity =new HttpEntity<String>("",header);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/orderBook/openOrderBook", HttpMethod.POST, httpEntity, String.class);
		
		try {
			JSONAssert.assertEquals("", response.getBody(), false);
		}catch(Exception e) {
			
		}
	}
}
