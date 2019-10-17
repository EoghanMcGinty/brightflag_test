package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.EnrollForm;
import com.brightflag.domain.Subject;


@Repository
public class SubjectRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Subject> getSubjects() {
		return jdbcTemplate.query("SELECT su.subjectID, su.subjectName, count(e.studentID) AS studentCount FROM subject AS su "
				+ "LEFT JOIN enrollments AS e ON su.subjectID = e.subjectID "
				+ "GROUP BY su.subjectID;",
				new BeanPropertyRowMapper<Subject>(Subject.class));
	}

	public Integer addSubject(EnrollForm enrollForm) {
		String sqlUpdate = " MERGE INTO subject (subjectName) KEY(subjectName) VALUES (?); ";
		jdbcTemplate.update(sqlUpdate, enrollForm.getSubjectName());
		String sqlQuery = "Select subjectID FROM subject AS su "
				+ "WHERE su.subjectName = ?;";
		return jdbcTemplate.queryForObject(sqlQuery, Integer.class, enrollForm.getSubjectName());
	}
	
}
