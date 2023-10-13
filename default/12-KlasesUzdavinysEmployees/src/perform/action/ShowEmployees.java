package perform.action;

import color.Color;
import employee.action.Employee;

public class ShowEmployees {
	
	public static void showEmployees(Employee[] employees) {
		
		System.out.println("\n");
		for (Employee item : employees)
			System.out.println(Color.YELLOW + item.getInfo() + Color.DEFAULT);
		System.out.println("\n");
		
	}

}
