package com.vzw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vzw.data.cassandra.DeviceCassandraRepository;
import com.vzw.data.cassandra.TechSpec;
import com.vzw.model.DeviceFeatureVO;
import com.vzw.model.TechSpecVO;

@Component
public class DeviceDAOImpl implements DeviceDAO {
	
	@Autowired
	private DeviceCassandraRepository deviceCassandraRepository;

	@Override
	public List<TechSpecVO> getTechSpec(String product) {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		List<TechSpecVO> techSpecList = new ArrayList<>();
		List<TechSpec> resultList = deviceCassandraRepository.getTechSpec(product);
		for (TechSpec tSpec : resultList) {
			TechSpecVO techSpec = new TechSpecVO();
			techSpec.setTitle(tSpec.getTitle());
			techSpec.setImageUrl(tSpec.getImageUrl());
			techSpec.setTechSpecFlag(tSpec.getTechSpecFlag());
			techSpec.setDetailedText(tSpec.getDetailText());
			techSpecList.add(techSpec);
		}	
		return techSpecList;
	}

	@Override
	public List<DeviceFeatureVO> getDeviceFeature(String product) {
		List<DeviceFeatureVO> featureList = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		List<Map> resultList = deviceCassandraRepository.getDeviceFeature(product);
		for (@SuppressWarnings("rawtypes") Map dFeature : resultList) {
			DeviceFeatureVO deviceFeature = new DeviceFeatureVO();
			deviceFeature.setDetailedText((String) dFeature.get("detailedText"));
			deviceFeature.setTitle((String) dFeature.get("title"));
			deviceFeature.setSmallImage((String) dFeature.get("smallImage"));
			deviceFeature.setImageOrVideUrl((String) dFeature.get("imageOrVideUrl"));
			featureList.add(deviceFeature);
		}
		return featureList;
	}

}
