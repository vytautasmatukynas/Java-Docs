package perform.action;

import color.Color;
import employee.action.Employee;

public class AvrgSalary {
	
	public static void avrgSalary(Employee[] employees) {
		
		int sumSalary = 0;
		
		for (Employee item : employees)
			sumSalary += item.getSalary();
			System.out.println(Color.YELLOW + "\nAvarage salary: " + (sumSalary / employees.length) + "\n" + Color.DEFAULT);

	}

}
