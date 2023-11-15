package web.libraries.gson;

import java.util.ArrayList;

public class StudentsList {

	int id;
	ArrayList<Student> student;

	public StudentsList(int id, ArrayList<Student> student) {
		this.id = id;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "web.random.libaries.Students [id=" + id + ", student=" + student + "]";
	}
	
	

}
