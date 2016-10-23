/**
 * 
 */
package com.vzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableCaching
public class RVApplication {
	
	public static void main(String[] args) {
	    SpringApplication.run(RVApplication.class, args);
	  }

}
