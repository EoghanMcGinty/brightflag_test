package com.brightflag.codetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brightflag.controller.SubjectAPIController;
import com.brightflag.domain.EnrollForm;
import com.brightflag.domain.Subject;
import com.brightflag.service.EnrollService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void NewSubject() {
		EnrollService enrollService = new EnrollService();
		EnrollForm enrollForm = new EnrollForm();
		enrollForm.setStudentID(2);
		enrollForm.setSubjectName("Finance");
		enrollService.enroll(enrollForm);
		SubjectAPIController subjectAPIController = null;
		List<Subject> subjects = subjectAPIController.getSubjects();
		assertEquals(subjects.get(5).getStudentCount(), Integer.valueOf(1));
	}
	
	@Test
	public void ExistingSubjectNewStudent() {
		EnrollService enrollService = new EnrollService();
		EnrollForm enrollForm = new EnrollForm();
		enrollForm.setStudentID(3);
		enrollForm.setSubjectName("Classics");
		enrollService.enroll(enrollForm);
		SubjectAPIController subjectAPIController = null;
		List<Subject> subjects = subjectAPIController.getSubjects();
		assertEquals(subjects.get(0).getStudentCount(), Integer.valueOf(3));	
	}
	
	@Test
	public void ExistingSubjectExistingStudent() {
		EnrollService enrollService = new EnrollService();
		EnrollForm enrollForm = new EnrollForm();
		enrollForm.setStudentID(2);
		enrollForm.setSubjectName("Classics");
		enrollService.enroll(enrollForm);
		SubjectAPIController subjectAPIController = null;
		List<Subject> subjects = subjectAPIController.getSubjects();
		assertEquals(subjects.get(0).getStudentCount(), Integer.valueOf(2));		
	}

}
