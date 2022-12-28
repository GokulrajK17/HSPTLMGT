package com.infy.hospitalmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.hospitalmanagement.dto.PatientDTO;
import com.infy.hospitalmanagement.entity.Patient;
import com.infy.hospitalmanagement.exception.PatientAdmissionException;
import com.infy.hospitalmanagement.repository.PatientRepository;
import com.infy.hospitalmanagement.validator.PatientValidator;
@Service(value="patientService")
@Transactional                                                                      ///doubt which to import javax or spring so gave spring. but having doubt
public class PatientServiceImpl  implements PatientService{
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<PatientDTO> getListOfPatients(String diagnosis) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		List<Patient> v = patientRepository.findBydiagnosis(diagnosis);
		if (v.isEmpty()) {
			throw new PatientAdmissionException("PatientService.PATIENT_UNAVAILABLE");
		}
		List<PatientDTO>dto=new ArrayList<PatientDTO>();
		for(Patient edto:v) {  
			PatientDTO p=new PatientDTO();
			p.setPatientName(edto.getPatientName());
			p.setGender(edto.getGender());
			p.setDiagnosis(edto.getDiagnosis());
			p.setAdmissionDate(edto.getAdmissionDate());
			p.setDateOfBirth(edto.getDateOfBirth());
			p.setPatientId(edto.getPatientId());
			dto.add(p);
		}
		return dto;
	}

	@Override
	public PatientDTO admitPatient(PatientDTO patientDTO) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		PatientValidator.validatePatient(patientDTO);
		Patient s = new Patient();
		s.setPatientId(patientDTO.getPatientId());
		s.setPatientName(patientDTO.getPatientName());
		s.setGender(patientDTO.getGender());
		s.setAdmissionDate(patientDTO.getAdmissionDate());
		s.setDateOfBirth(patientDTO.getDateOfBirth());
		s.setDiagnosis(patientDTO.getDiagnosis());
		patientRepository.save(s);
		patientDTO.setPatientId(s.getPatientId());		
		return patientDTO;
	}
}
















