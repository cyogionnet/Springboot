package com.vzw.manager;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeviceManager {
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@Cacheable("techSpec")
	public String getTechSpec(String product) {
		ServiceInstance instance = loadBalancer.choose("catalog");
		URI uri = instance.getUri();
		String url = uri.toString() + "/product/" + product + "/techSpec";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
		return response.getBody();
	}
	
	@Cacheable("deviceFeature")
	public String getDeviceFeature(String product) {
		ServiceInstance instance = loadBalancer.choose("catalog");
		URI uri = instance.getUri();
		String url = uri.toString() + "/product/" + product + "/deviceFeature";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
		return response.getBody();
	}

}
