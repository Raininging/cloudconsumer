package com.founder.ark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.founder.ark.DemoMbdApi;

@RestController
public class ConsumerController {
	
	@Autowired
	private DemoMbdApi api;
	
	@Autowired
	private RestTemplate t;
	
	@RequestMapping(value="/testConsumer/test")
	public String test(String name){
		String result = t.getForEntity("http://DEMO-PROVIDER/test", String.class).getBody();
		return result;
	}
	
	@RequestMapping(value="/testConsumer/hello")
	public String hello(String name){
		return api.sayHello(name);
	}
}
