package com.vzw;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vzw.data.cassandra.TechSpecCassandraRepository;
import com.vzw.data.cassandra.DeviceFeature;
import com.vzw.data.cassandra.DeviceFeatureCassandraRepository;
import com.vzw.data.cassandra.TechSpec;


@RestController
@RequestMapping("/product/{deviceId}")
public class CatalogController {
	
private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private TechSpecCassandraRepository deviceCassandraRepository;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private DeviceFeatureCassandraRepository deviceFeatureCassandraRepository;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/techSpec")
	@Cacheable("getTechSpecFromDataStore")
	public List<TechSpec> getTechSpecFromDataStore(@PathVariable String deviceId){
		logger.info("CatalogController ------ Getting the tech specs");
		return deviceCassandraRepository.getTechSpec(deviceId);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/deviceFeature")
	@Cacheable("getDeviceFeatureFromDataStore")
	public List<DeviceFeature> getDeviceFeatureFromDataStore(@PathVariable String deviceId){
		logger.info("CatalogController ------Getting the device features");
		return deviceFeatureCassandraRepository.getDeviceFeature(deviceId);
	}

}
