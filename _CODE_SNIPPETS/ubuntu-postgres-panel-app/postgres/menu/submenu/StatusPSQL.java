package linux.ubuntu.postgres.panel.postgres.menu.submenu;

import java.util.InputMismatchException;

import linux.ubuntu.postgres.panel.ui.Color;
import linux.ubuntu.postgres.panel.ui.Input;
import linux.ubuntu.postgres.panel.postgres.terminal.ExecuteCommand;
import linux.ubuntu.postgres.panel.ui.PostgresMenu;
import linux.ubuntu.postgres.panel.postgres.commands.StatusPsqlCommand;

public class StatusPSQL {
	
	public static void statusMenu() {
		
		StatusPsqlCommand status = StatusPsqlCommand.STATUS_PSQL;
		
		while (true) {
			String commandAction;
	
			PostgresMenu.statusPsqlMenu();
	
			try {
				
				int inputCommandType = Input.inputInt("Enter your action: ");
				
				if (inputCommandType == 3) {
					System.out.println(Color.CYAN + "\nExiting PSQL Status Panel...\n\n" + Color.CYAN );
					break;
				}
	
				switch (inputCommandType) {
					case 1: // Returns PSQL version
						commandAction = status.getVersion();
						ExecuteCommand.sudo(commandAction);
					case 2: // Returns PSQL status
						commandAction = status.getStatus();
						ExecuteCommand.sudo(commandAction);
					default:
						System.out.println( Color.RED + "\n\n" + "Please select number from 1 to 3." + "\n\n" + Color.DEFAULT );
				}
				
			} catch (InputMismatchException error) {
				System.out.println( Color.RED + "\n\n" + "Please select number." + "\n\n" + Color.DEFAULT );
				
				Input.consumeOutput(); // Consume the invalid input to prevent an infinite loop
			}
		}
		
	}
	
}
