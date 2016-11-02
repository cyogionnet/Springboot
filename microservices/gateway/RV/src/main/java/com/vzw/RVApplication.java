/**
 * 
 */
package com.vzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableZuulProxy
@SpringBootApplication
@EnableCaching
@EnableGlobalMethodSecurity
public class RVApplication {
	
	public static void main(String[] args) {
	    SpringApplication.run(RVApplication.class, args);
	  }

}
