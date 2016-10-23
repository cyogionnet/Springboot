package com.vzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MobileApplication {

	public static void main(String[] args) {
	    SpringApplication.run(MobileApplication.class, args);
	  }
}
