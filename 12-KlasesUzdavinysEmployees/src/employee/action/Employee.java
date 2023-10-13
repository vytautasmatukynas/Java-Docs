package employee.action;

public class Employee {
	
	private int id;
	private String name;
	private String position;
	private int salary;
	
	public Employee(int id, String name, String position, int salary) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	public Employee(String name, String position, int salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPosition() {
		return position;
	}

	public int getSalary() {
		return salary;
	}

	public String getInfo() {
		return "id: " + id + " | name: " + name + " | position: " + position + " | salary: " + salary;
	}
	
	public void setName(String name) {
			this.name = name;
	}
	
	public void setPosition(String position) {
			this.position = position;
	}

	public void setSalary(int salary) {
			this.salary = salary;
	}

}
