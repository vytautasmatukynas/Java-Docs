package employee.action;

import position.value.Position;

public class PopulateArray {

	public static void addEmployee(Position position, Employee[] employees) {
		
		employees[0] = new Employee(1, "Jonas", position.developer(), 2000);
		employees[1] = new Employee(2, "Petras", position.manager(), 1300);
		employees[2] = new Employee(3, "Juozas", position.tester(), 1500);
		employees[3] = new Employee(4, "Jonas", position.developer(), 1900);
		employees[4] = new Employee(5, "Petras", position.manager(), 2300);
		
	}

}
