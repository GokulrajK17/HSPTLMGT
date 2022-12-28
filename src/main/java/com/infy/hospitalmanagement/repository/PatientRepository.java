package com.infy.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.hospitalmanagement.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient,Integer>{
	List<Patient>findBydiagnosis(String diagnosis);

}
