package menu;
import java.util.Scanner;

import color.Color;
import employee.action.Employee;
import perform.action.*;

public class MainMenu {
	
	public static void chooseMenu (Scanner scanner, Employee[] employees) {
		
		while (true) {
			
			System.out.println(Color.YELLOW + "\nChoose action:\n" + Color.DEFAULT
					+ "1. Print Employees.\n"
					+ "2. Print Employees with max Salary.\n"
					+ "3. Print average Salary.\n"
					+ "4. Find Employees by Position.\n"
					+ "5. Change Employee data.\n"
					+ Color.RED + "6. Exit.\n"
					+ "\n"
					+ Color.GREEN + "Enter your action: " + Color.DEFAULT);
			
			try {
				int chooseAction = scanner.nextInt();
				
				if (chooseAction == 6) {
					System.out.println(Color.CYAN + "\nExiting..." + Color.DEFAULT);
					break;
				}
				
				switch (chooseAction) {
					case 1: 
						ShowEmployees.showEmployees(employees);
						break;
					case 2: 
						MaxSalary.getEmployeeWithMaxSalary(employees);
						break;
					case 3: 
						AvrgSalary.avrgSalary(employees);
						break;
					case 4: 
						PositionMenu.choosePosition(employees, scanner);
						break;
					case 5: 
						ChangeById.changeEmployeeById(employees, scanner);
						break;
					default:
						System.err.println( "\n\nPlease select number from 1 to 6.\n\n");
						continue;
				} 
				
			} catch (java.util.InputMismatchException error) {
				System.err.println("\n\nPlease enter number.\n\n");
				scanner.nextLine();
				continue;
			}
			
		}
		
	}

}
