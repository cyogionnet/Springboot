package com.vzw.data.cassandra;

import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface DeviceCassandraRepository extends CassandraRepository<TechSpec> {
	
	@Query("select * from techSpec where product=?0")
	public List<TechSpec> getTechSpec(String product);
	
	@Query("select * from deviceFeature where product=?0")
	public List<Map> getDeviceFeature(String product);

}
