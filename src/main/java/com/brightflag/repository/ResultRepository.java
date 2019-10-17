package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.Result;

@Repository
public class ResultRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Result> getResults() {
		return jdbcTemplate.query("SELECT st.firstName, st.lastName, su.subjectName, "
				+ "ex.examName, r.grade FROM result AS r "
				+ "JOIN student AS st ON r.studentId = st.studentID "
				+ "JOIN exam AS ex ON r.examID = ex.examID "
				+ "JOIN subject AS su ON ex.subjectID = su.subjectID "
				+ "GROUP BY st.firstName, ex.examName;",
				new BeanPropertyRowMapper<Result>(Result.class));
	}
	
}
