package com.brightflag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightflag.domain.EnrollForm;
import com.brightflag.repository.EnrollmentRepository;
import com.brightflag.repository.SubjectRepository;

@Service
public class EnrollService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;

	public void enroll(EnrollForm enrollForm) {
		Integer id = subjectRepository.addSubject(enrollForm);
		enrollmentRepository.addEnrollment(enrollForm, id);
	}

}
