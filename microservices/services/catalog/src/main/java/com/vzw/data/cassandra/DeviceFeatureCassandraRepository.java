package com.vzw.data.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface DeviceFeatureCassandraRepository<T> extends CassandraRepository<DeviceFeature> {
	
	@Query("select * from deviceFeature where product=?0")
	public List<DeviceFeature> getDeviceFeature(String product);

}
