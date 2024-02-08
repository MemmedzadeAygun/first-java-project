package az.developia.springjava13;

import java.util.List;

import az.developia.springjava13.component.StudentEntity;

public class StudentResponse {
	private List<StudentEntity> students;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

}
