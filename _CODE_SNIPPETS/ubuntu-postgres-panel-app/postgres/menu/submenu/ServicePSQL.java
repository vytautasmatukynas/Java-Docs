package linux.ubuntu.postgres.panel.postgres.menu.submenu;

import java.util.InputMismatchException;

import linux.ubuntu.postgres.panel.ui.Color;
import linux.ubuntu.postgres.panel.ui.Input;
import linux.ubuntu.postgres.panel.ui.PostgresMenu;
import linux.ubuntu.postgres.panel.postgres.commands.ServicePsqlCommand;
import linux.ubuntu.postgres.panel.postgres.terminal.ExecuteCommand;
import linux.ubuntu.postgres.panel.postgres.commands.StatusPsqlCommand;

public class ServicePSQL {

	public static void serviceMenu() {
		
		ServicePsqlCommand service = ServicePsqlCommand.SERVICE_PSQL;
		StatusPsqlCommand status = StatusPsqlCommand.STATUS_PSQL;
		
		while (true) {
			String commandAction;
	
			PostgresMenu.servicePsqlMenu();
			
			try {
				
				int inputCommandType = Input.inputInt("Enter your action: ");
				
				if (inputCommandType == 6) {
					System.out.println(Color.CYAN + "\nExiting PSQL Service Panel...\n\n" + Color.CYAN );
					break;
				}
	
				switch (inputCommandType) {
					case 1: // Enables PSQL
						commandAction = service.getEnable();
						ExecuteCommand.sudo(commandAction);
					case 2: // Starts PSQL
						commandAction = service.getStart();
						ExecuteCommand.sudo(commandAction);
					case 3: // Restarts PSQL
						commandAction = service.getRestart();
						ExecuteCommand.sudo(commandAction);
					case 4: // Stops PSQL
						commandAction = service.getStop();
						ExecuteCommand.sudo(commandAction);
					case 5: // Returns PSQL status
						commandAction = status.getStatus();
						ExecuteCommand.sudo(commandAction);
					default:
						System.out.println( Color.RED + "\n\n" + "Please select number from 1 to 6." + "\n\n" + Color.DEFAULT );
				}
				
			} catch (InputMismatchException error) {
				System.out.println( Color.RED + "\n\n" + "Please select number." + "\n\n" + Color.DEFAULT );
				
				Input.consumeOutput(); // Consume the invalid input to prevent an infinite loop
			}
		}

	}
	
}