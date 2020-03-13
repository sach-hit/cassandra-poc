package com.devpoc.cassandra.db.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devpoc.cassandra.db.domain.Hospital;

public interface HospitalDataRepository extends CassandraRepository <Hospital, String>{

}
