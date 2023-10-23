

public class Students {

	int id;
	Student student;

	public Students(int id, Student student) {
		this.id = id;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", student=" + student + "]";
	}
	
	

}
