package com.devpoc.cassandra.db.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpoc.cassandra.db.domain.Hospital;
import com.devpoc.cassandra.db.domain.Patient;
import com.devpoc.cassandra.db.repo.HospitalDataRepository;
import com.devpoc.cassandra.db.repo.PatientRepository;

@RestController
@RequestMapping ("/api/hospitaldetails")
public class HospitalInfoController {
	
	 @Autowired
	 HospitalDataRepository hospitaldatarepo;
	 
	 @Autowired
	 PatientRepository patientRepo;
	 
	 
	 @GetMapping("/hospital/{id}")
	 public Optional<Hospital> getHospital(@PathVariable String id)
	 {
	  Optional<Hospital> hospitaldata = hospitaldatarepo.findById(id);
	  return hospitaldata;
	 }
	 
	 @PutMapping("/hospital/{id}")
	 public Optional<Hospital> updateHospital(@RequestBody Hospital newhsp, @PathVariable String id)
	 {
	  Optional<Hospital> optionalhsp = hospitaldatarepo.findById(id);
	  if (optionalhsp.isPresent()) {
		  Hospital hsp = optionalhsp.get();
		  hsp.setHospitalNumber(newhsp.getHospitalNumber());
		  hsp.setName(newhsp.getName());
		  hsp.setBedInfo(newhsp.getBedInfo());
		  //hsp.setPatientId(newhsp.getPatientId());
		  hospitaldatarepo.save(hsp);
	  }
	  return optionalhsp;
	 }
	
	 /*@DeleteMapping(value = "/employee/{id}", produces = "application/json; charset=utf-8")
	 public String deleteEmployee(@PathVariable String id) {
	  Boolean result = employeeRepository.existsById(id);
	  employeeRepository.deleteById(id);
	  return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	 }
	 */
	 @PostMapping("/hospital")
	 public Hospital addHospital(@RequestBody Hospital hospitaldata)
	 { return hospitaldatarepo.save(hospitaldata);
	 }
	 
	 @PostMapping("/patient")
	 public Patient addPatient(@RequestBody Patient patient)
	 { return patientRepo.save(patient);
	 }
	 
	 @GetMapping("/hospitalData/{id}")
	 public List<Patient> getAllPatient(@PathVariable String id)
	 {
	  Optional<Hospital> hospitaldata = hospitaldatarepo.findById(id);
	  
	  if(hospitaldata.isPresent()) {
		  
		  return patientRepo.findByHospitalId(id);
		  
	  }
	   return null;
	 }

}
