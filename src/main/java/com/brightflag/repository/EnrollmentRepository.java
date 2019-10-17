package com.brightflag.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.EnrollForm;

@Repository
public class EnrollmentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addEnrollment(EnrollForm enrollForm, Integer id) {
		String sqlUpdate = "MERGE INTO enrollments VALUES(?, ?);";
		jdbcTemplate.update(sqlUpdate, enrollForm.getStudentID(), id);
	}
}
