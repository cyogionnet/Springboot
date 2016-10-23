package com.vzw.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.vzw.dao.DeviceDAO;
import com.vzw.model.DeviceFeatureVO;
import com.vzw.model.TechSpecVO;

@Component
public class DeviceManager {
	
	@Autowired
	DeviceDAO deviceDAOImpl;
	
	@Cacheable("techSpec")
	public List<TechSpecVO> getTechSpec(String product) {
		return deviceDAOImpl.getTechSpec(product);
	}
	
	@Cacheable("deviceFeature")
	public List<DeviceFeatureVO> getDeviceFeature(String product) {
		return deviceDAOImpl.getDeviceFeature(product);
	}

}
