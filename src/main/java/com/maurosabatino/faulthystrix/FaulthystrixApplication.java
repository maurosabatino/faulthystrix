package com.maurosabatino.faulthystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class FaulthystrixApplication {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/hello/{param}",method = RequestMethod.GET)
	public String toRead(@PathVariable("param") String param) throws Exception {
		return helloService.readingList(param);
	}



	public static void main(String[] args) {
		SpringApplication.run(FaulthystrixApplication.class, args);
	}
}
