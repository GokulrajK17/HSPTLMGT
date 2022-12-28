package com.infy.hospitalmanagement.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class PatientDTO{

	private Integer patientId;
	@NotNull(message="{patient.name.notpresent}")
	@Pattern(regexp = "([a-zA-Z]+)(\\s[a-zA-Z]+)*",message="{patient.name.invalid}")          ///in pdf, only one slash
	private String patientName;
	@NotNull(message="{patient.gender.notpresent}")
	@Pattern(regexp="(Female|Male|Others)",message="{patient.gender.invalid}")
	private String gender;
	@NotNull(message="{patient.DOB.notpresent}")
	private LocalDate dateOfBirth;
	@NotNull(message="{patient.admissiondate.notpresent}")
	@FutureOrPresent(message="{patient.admissiondate.invalid}")
	@PastOrPresent(message="{patient.admissiondate.invalid}")
	private LocalDate admissionDate;
	@NotNull(message="{patient.diagnosis.notpresent}")
	@Pattern(regexp="([a-zA-Z]+)(\\s[a-zA-Z]+)*",message="{patient.diagnosis.invalid}")                     ///in pdf, only one slash
	private String diagnosis;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}
