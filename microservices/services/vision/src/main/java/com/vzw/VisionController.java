package com.vzw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vision")
public class VisionController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	CacheManager cacheManager;
	
	@RequestMapping("/customer/{accountNo}")
	public String retrieveCustomer(@PathVariable String accountNo) {
		String visionResponse = testService.getResponse();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + visionResponse);
		Cache cache = cacheManager.getCache("customerInfo");
		cache.put(accountNo, visionResponse);
		return visionResponse;
	}	
	
	@RequestMapping("test/{accountNo}")
	public String viewCustomer(@PathVariable String accountNo){
		Cache cache = cacheManager.getCache("customerInfo");
		return (String) cache.get(accountNo).get();
	}
	
}
