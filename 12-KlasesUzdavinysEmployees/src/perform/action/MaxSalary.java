package perform.action;

import color.Color;
import employee.action.Employee;

public class MaxSalary {
	
	public static void getEmployeeWithMaxSalary(Employee[] employees) {
		
		for (Employee item : employees)
			if (item.getSalary() == getMaxSalary(employees))
				System.out.println(Color.YELLOW + "\nMax salary: " + item.getInfo() + "\n" + Color.DEFAULT);
		
	}
	
	private static int getMaxSalary(Employee[] employees) {
		
		int maxSalary = 0;
		for (Employee item : employees)
			if (maxSalary < (int) item.getSalary())
				maxSalary = item.getSalary();
				
		return maxSalary;
		
	}
	
}
