package com.infy.hospitalmanagement.validator;

import java.time.LocalDate;

import com.infy.hospitalmanagement.dto.PatientDTO;
import com.infy.hospitalmanagement.exception.PatientAdmissionException;

public class PatientValidator {

	public PatientValidator() {
		super();                                                          // not in pdf
		// TODO Auto-generated constructor stub
	}
   public static void validatePatient(PatientDTO patientDTO) throws PatientAdmissionException{
	   if(isValidDateOfBirth(patientDTO.getDateOfBirth())==false){
		   
		  
		   throw new PatientAdmissionException("PatientValidator.INVALID_DOB");
	   }
   }
   public static Boolean isValidDateOfBirth(LocalDate dateOfBirth) throws PatientAdmissionException {
	  LocalDate today=LocalDate.now();
	  LocalDate future=today.minusYears(100);
	  if(dateOfBirth.isAfter(today)||(dateOfBirth.isBefore(future))) {
		  return false;
	  }
   {
	return true;   
   }
   }
}
