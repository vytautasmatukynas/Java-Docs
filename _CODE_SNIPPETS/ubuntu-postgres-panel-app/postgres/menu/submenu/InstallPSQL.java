package linux.ubuntu.postgres.panel.postgres.menu.submenu;

import java.util.InputMismatchException;

import linux.ubuntu.postgres.panel.ui.Color;
import linux.ubuntu.postgres.panel.ui.Input;
import linux.ubuntu.postgres.panel.ui.PostgresMenu;
import linux.ubuntu.postgres.panel.postgres.commands.InstallCommand;
import linux.ubuntu.postgres.panel.postgres.commands.StatusPsqlCommand;
import linux.ubuntu.postgres.panel.postgres.terminal.ExecuteCommand;

public class InstallPSQL {

	public static void installMenu() {
		
		StatusPsqlCommand status = StatusPsqlCommand.STATUS_PSQL;
		InstallCommand install = InstallCommand.INSTALL;
		
		while (true) {
			String sudoPassword = null;
			String commandAction;
	
			PostgresMenu.installPsqlMenu();
	
			try {
				
				int inputCommandType = Input.inputInt("Enter your action: ");
				
				if ( inputCommandType <= 4 && inputCommandType > 0 ) {
					sudoPassword = Input.inputString("\nEnter sudo password: ");
				}
	
				if ( inputCommandType == 7 ) {
					System.out.println(Color.CYAN + "\nExiting PSQL Install Panel...\n\n" + Color.CYAN );
					break;
				}
	
				switch (inputCommandType) {
					case 1: // Get's GPG key for PSQL
						commandAction = install.getGpgKey();
						ExecuteCommand.echoSudoS(sudoPassword, commandAction);
					case 2: // Create's repository of PSQL
						commandAction = install.getRepo();
						ExecuteCommand.echoSudoS(sudoPassword, commandAction);
					case 3: // Install's PSQL
						for ( String command : install.getInstall() )
							ExecuteCommand.echoSudoS(sudoPassword, command);
					case 4: // Launches all commands to install PSQL
						for ( String command : install.allCommands())
							ExecuteCommand.echoSudoS(sudoPassword, command);
					case 5: // Return's PSQL status
						commandAction = status.getStatus();
						ExecuteCommand.sudo(commandAction);
					case 6: // Returns's PSQL version
						commandAction = status.getVersion();
						ExecuteCommand.sudo(commandAction);
					default:
						System.out.println( Color.RED + "\n\n"
											+ "Please select number from 1 to 6."
											+ "\n\n" + Color.DEFAULT );
				}
				
			} catch (InputMismatchException error) {
				System.out.println( Color.RED + "\n\n"
									+ "Please select number." + "\n\n"
									+ Color.DEFAULT );
				
				Input.consumeOutput(); // Consume the invalid input to prevent an infinite loop
			}
		}

	}
	
}