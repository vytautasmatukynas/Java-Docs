package linux.ubuntu.postgres.panel.ui;

public class PostgresMenu {
	
	
	public static void psqlMenu() {
		System.out.println(Color.YELLOW + "\n--> Enter action you want to perform <--\n\n" + Color.DEFAULT
				+ "1. Setup PSQL.\n"
				+ "2. Actions with PSQL services.\n" 
				+ "3. PSQL status.\n" 
				+ Color.CYAN + "4. Exit.\n" + Color.DEFAULT
				+ "\n");
	}
	
	public static void installPsqlMenu() {
		System.out.println(Color.YELLOW + "\n--> Enter action you want to perform <--" + "\n\n"  + Color.DEFAULT
				+ "1. Download GPG key.\n"  
				+ "2. Add repository.\n" + Color.DEFAULT 
				+ "3. Install PostgreSQL.\n"
				+ Color.GREEN + "4. Execute all actions to install.\n" + Color.DEFAULT 
				+ "5. Status.\n" 
				+ "6. Version.\n" 
				+ Color.CYAN + "7. Exit.\n" + Color.DEFAULT
				+ "\n");
	}
	
	public static void servicePsqlMenu() {
		System.out.println(Color.YELLOW + "\n--> Enter action you want to perform <--" + "\n\n"
				+ Color.GREEN + "1. Enable.\n"  
				+ "2. Start.\n" + Color.DEFAULT 
				+ "3. Restart.\n"
				+ Color.RED + "4. Stop.\n" + Color.DEFAULT 
				+ "5. Status.\n" 
				+ Color.CYAN + "6. Exit.\n" + Color.DEFAULT
				+ "\n");
	}
	
	public static void statusPsqlMenu() {
		System.out.println(Color.YELLOW + "\n--> Enter STATUS action you want to perform <--" + "\n\n" + Color.DEFAULT 
				+ "1. Version.\n"
				+ "2. Status.\n" 
				+ Color.CYAN + "3. Exit.\n" + Color.DEFAULT
				+ "\n");
	}

}
