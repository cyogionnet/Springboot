package com.vzw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vzw.manager.DeviceManager;

@RestController
@RequestMapping("/device/{deviceId}")
public class DeviceController {

	private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired
	private DeviceManager deviceManager;
	
	@RequestMapping("/techSpec")
	@Cacheable("getTechSpec")
	public String getTechSpec(@PathVariable String deviceId){
		logger.info("Getting the tech specs");
		return deviceManager.getTechSpec(deviceId);
	}
	
	@RequestMapping("/deviceFeature")
	@Cacheable("getDeviceFeature")
	public String getDeviceFeature(@PathVariable String deviceId){
		logger.info("Getting the device features");
		return deviceManager.getDeviceFeature(deviceId);
	}
	
}
