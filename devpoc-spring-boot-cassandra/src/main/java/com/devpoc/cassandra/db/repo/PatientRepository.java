package com.devpoc.cassandra.db.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.devpoc.cassandra.db.domain.Patient;

public interface PatientRepository extends CassandraRepository <Patient, Long>{

	List<Patient> findByHospitalId(String hospitalId);
	
	//List<Patient> getAllPatientwithHospitalId(String hospitalId);

}
