package perform.action;

import color.Color;
import employee.action.Employee;

public class FindPosition {
	
	public static void getPositions(String position, Employee[] employees) {
		
		System.out.println("\n");
		
		for (Employee item : employees)
			if (item.getInfo().contains(position))
					System.out.println(Color.YELLOW + "Position DEVELOPER: " + item.getInfo() + Color.DEFAULT);
		
		System.out.println("\n");
		
	}

}
