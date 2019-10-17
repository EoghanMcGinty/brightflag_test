package com.brightflag.domain;

public class EnrollForm {
	
	@Override
	public String toString() {
		return "EnrollForm [studentID=" + studentID + ", subjectName=" + subjectName + "]";
	}
	private Integer studentID;
	private String subjectName;
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
