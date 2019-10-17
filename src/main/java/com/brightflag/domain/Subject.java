package com.brightflag.domain;

public class Subject {

	private Integer subjectID;
	private String subjectName;
	private Integer studentCount;

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	
	public Integer getSubjectID() {
		return subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectName=" + subjectName + "]";
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}


}
