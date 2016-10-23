package com.vzw;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vzw.model.DeviceVO;

@RestController
public class RVDeviceController {
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@Autowired
	CacheManager cacheManager;
	
	@RequestMapping("/product/{id}")
	public DeviceVO getDeviceDetails(@PathVariable String id, @RequestParam(name="accountNo", required=false) String accountNo) {
		ServiceInstance instance = loadBalancer.choose("device");
		DeviceVO device = new DeviceVO();
		URI uri = instance.getUri();
		String url = uri.toString() + "/device/" + id + "/techSpec";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		device.setTechSpec(response.getBody());
		String featureUrl = uri.toString() + "/device/" + id + "/deviceFeature";
		response = restTemplate.getForEntity(featureUrl, String.class);
		device.setFeature(response.getBody());
		if (accountNo != null) {
			Cache cache = cacheManager.getCache("customerInfo");
			device.setCustomerInfo((String) cache.get(accountNo).get());
		}
		return device;
	}
}
