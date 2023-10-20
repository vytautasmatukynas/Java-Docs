
public class Student {

	String name;
	long age;
	String studying;

	public Student(String name, long age, String studying) {

		this.name = name;
		this.age = age;
		this.studying = studying;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getStudying() {
		return studying;
	}

	public void setStudying(String studying) {
		this.studying = studying;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studying=" + studying + "]";
	}
	
	

}
