package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.EnrollForm;
import com.brightflag.domain.Student;

@Repository
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> getStudents() {
		List<Student> students =  jdbcTemplate.query("SELECT st.studentID, st.firstName, st.lastName FROM student AS st;",
				new BeanPropertyRowMapper<Student>(Student.class));
		
		for(Student student : students) {
			List<String> subjectStrings = jdbcTemplate.queryForList("SELECT su.subjectName FROM subject AS su "
					+ "JOIN enrollments AS e ON su.subjectID = e.subjectID "
					+ "JOIN student AS st ON e.studentID = st.studentID "
					+ "WHERE st.studentID = " + student.getStudentID() + ";", String.class);
			student.setSubjects(subjectStrings);
		}
		
		return students;
	}
}
