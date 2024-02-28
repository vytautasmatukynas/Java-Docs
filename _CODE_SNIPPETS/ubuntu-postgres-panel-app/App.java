package linux.ubuntu.postgres.panel;

import linux.ubuntu.postgres.panel.ui.Input;
import linux.ubuntu.postgres.panel.postgres.menu.MenuPSQL;

public class App {

	public static void main(String[] args) {

		MenuPSQL.choosePsqlSubmenu();

		Input.close();

	}

}