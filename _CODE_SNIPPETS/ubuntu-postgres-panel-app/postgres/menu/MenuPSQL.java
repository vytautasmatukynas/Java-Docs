package linux.ubuntu.postgres.panel.postgres.menu;

import java.util.InputMismatchException;

import linux.ubuntu.postgres.panel.ui.Color;
import linux.ubuntu.postgres.panel.ui.Input;
import linux.ubuntu.postgres.panel.ui.PostgresMenu;
import linux.ubuntu.postgres.panel.postgres.menu.submenu.StatusPSQL;
import linux.ubuntu.postgres.panel.postgres.menu.submenu.InstallPSQL;
import linux.ubuntu.postgres.panel.postgres.menu.submenu.ServicePSQL;


public class MenuPSQL {

	public static void choosePsqlSubmenu() {
		
		while (true) {
				PostgresMenu.psqlMenu();

			try {
				int inputCommandType = Input.inputInt("Enter your action: ");
		
				if (inputCommandType == 4) {
					System.out.print(Color.CYAN + "\nExiting...\n\n" + Color.DEFAULT);
					break;
				}
				
				switch (inputCommandType) {
					case 1 -> InstallPSQL.installMenu();
					case 2 -> ServicePSQL.serviceMenu();
					case 3 -> StatusPSQL.statusMenu();
					default -> System.out.println(Color.RED + "\nPlease select number from 1 to 3.\n\n" + Color.DEFAULT);
				}

			} catch (InputMismatchException error) {
				System.out.println(Color.RED + "\nPlease select number.\n\n" + Color.DEFAULT);

				Input.consumeOutput(); // Consume the invalid input to prevent an infinite loop
			}
		}

	}

}