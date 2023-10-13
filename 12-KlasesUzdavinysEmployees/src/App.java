import java.util.Scanner;

import employee.action.Employee;
import employee.action.PopulateArray;
import menu.MainMenu;
import position.value.Position;

public class App {

	public static void main(String[] args) {
		
		// INPUT. Create instance of Scanner class
		Scanner scanner = new Scanner(System.in);
		
		// reference variable to ENUM object
		Position position = Position.POSITION;
		
		// create and populate ARRAY
		Employee[] employees = new Employee[5];
		// populate Array with data
		PopulateArray.addEmployee(position, employees);
		// start main menu
		MainMenu.chooseMenu(scanner, employees);
		
		// close INPUT
		scanner.close();
		
	}






	


}
