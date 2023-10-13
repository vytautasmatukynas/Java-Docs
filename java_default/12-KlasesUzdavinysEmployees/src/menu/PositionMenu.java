package menu;

import java.util.Scanner;

import color.Color;
import employee.action.Employee;
import position.value.Position;
import perform.action.FindPosition;

public class PositionMenu {
	
	public static void choosePosition(Employee[] employees, Scanner scanner) {
		
		Position position = Position.POSITION;
		
		while (true) {
			System.out.println(Color.YELLOW + "\nChoose Position:\n" + Color.DEFAULT
					+ "1. Developer.\n"
					+ "2. Manager.\n"
					+ "3. Tester.\n"
					+ Color.RED + "4. Exit.\n"
					+ Color.GREEN + "\nEnter your action: " + Color.DEFAULT);
			
			try {
				int chooseAction = scanner.nextInt();
				
				if (chooseAction == 4) {
					System.out.println(Color.CYAN + "\nExiting to main menu..." + Color.DEFAULT);
					break;
				}
				
				switch (chooseAction) {
					case 1: 
						FindPosition.getPositions(position.developer(), employees);
						break;
					case 2: 
						FindPosition.getPositions(position.manager(), employees);
						break;
					case 3: 
						FindPosition.getPositions(position.tester(), employees);
						break;
					case 4: 
						System.out.println("\n\nExiting to Main...\n");
						break;
					default:
						System.err.println("\n\nPlese select number from 1 to 4\n\n");
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
