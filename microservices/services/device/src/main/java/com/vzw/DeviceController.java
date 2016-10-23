package com.vzw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vzw.manager.DeviceManager;
import com.vzw.model.DeviceFeatureVO;
import com.vzw.model.TechSpecVO;

@RestController
@RequestMapping("/device/{deviceId}")
public class DeviceController {

	@Autowired
	private DeviceManager deviceManager;
	
	@RequestMapping("/techSpec")
	@Cacheable("getTechSpec")
	public List<TechSpecVO> getTechSpec(@PathVariable String deviceId){
		return deviceManager.getTechSpec(deviceId);
	}
	
	@RequestMapping("/deviceFeature")
	@Cacheable("getDeviceFeature")
	public List<DeviceFeatureVO> getDeviceFeature(@PathVariable String deviceId){
		return deviceManager.getDeviceFeature(deviceId);
	}
	
}
