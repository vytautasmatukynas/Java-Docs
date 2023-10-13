package perform.action;

import java.util.Scanner;

import color.Color;
import employee.action.Employee;
import position.value.Position;

public class ChangeById {
	
	public static void changeEmployeeById(Employee[] employees, Scanner scanner) {
		
		int employeeId;
		
		while (true) {
			try {
			System.out.println("\nEnter id: " );
			employeeId = scanner.nextInt();
			scanner.nextLine();
			if (employeeId <= employees.length) {
				break;
			} else {
				System.out.printf("\nPlease Enter number from 1 to %s", employees.length);
			}
			} catch (java.util.InputMismatchException error) {
				System.err.println("\n\nPlease enter number.\n\n");
				scanner.nextLine();
				continue;
			}
		}
		
		System.out.println("\nEnter name: " );
		String newName = scanner.nextLine();
		
		String changePosition = positionMenu(scanner);
		scanner.nextLine();
		
		System.out.println("\nEnter salary: ");
		int newSalary = scanner.nextInt();
		
		for (Employee id : employees)
			if (employeeId == id.getId())
				employees[employeeId - 1] = new Employee(newName, changePosition, newSalary);
				System.out.printf(Color.YELLOW + "\nEmployee with id[%s] was changed\n" + Color.DEFAULT, employeeId);

	}

	public static String positionMenu(Scanner scanner) {
		
		Position position = Position.POSITION;
	
		while (true) {
			System.out.println(Color.YELLOW + "\nChoose postion:\n" + Color.DEFAULT
					+ "1. Developer.\n"
					+ "2. Manage.\n"
					+ "3. Tester.\n"
					+ "\n"
					+ Color.GREEN + "Enter your action: " + Color.DEFAULT);
			
			int newPosition = scanner.nextInt();
			
			switch (newPosition) {
				case 1:
					return position.developer();
				case 2:
					return position.developer();
				case 3:
					return position.developer();
				default:
					System.err.println("\n\nPlease select number from 1 to 3.\n\n");
					continue;
			}
		}
		
	}

}
