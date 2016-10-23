package com.vzw.dao;

import java.util.List;

import com.vzw.model.DeviceFeatureVO;
import com.vzw.model.TechSpecVO;

public interface DeviceDAO {
	
	public List<TechSpecVO> getTechSpec(String product);
	
	public List<DeviceFeatureVO> getDeviceFeature(String product);

}
