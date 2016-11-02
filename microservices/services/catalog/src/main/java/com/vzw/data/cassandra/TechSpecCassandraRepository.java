package com.vzw.data.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface TechSpecCassandraRepository<T> extends CassandraRepository<TechSpec> {
	
	@Query("select * from techSpec where product=?0")
	public List<TechSpec> getTechSpec(String product);


}
