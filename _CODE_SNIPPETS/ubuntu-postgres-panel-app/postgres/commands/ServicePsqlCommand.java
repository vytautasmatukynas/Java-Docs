package linux.ubuntu.postgres.panel.postgres.commands;

/**
 * Constants for PSQL services command lines
 */
public enum ServicePsqlCommand {

	SERVICE_PSQL("systemctl enable postgresql", 
			"systemctl start postgresql", 
			"systemctl restart postgresql",
			"systemctl stop postgresql");

	private final String enable;
	private final String start;
	private final String restart;
	private final String stop;

	private ServicePsqlCommand(String enable, String start, String restart, String stop) {
		this.enable = enable;
		this.start = start;
		this.restart = restart;
		this.stop = stop;
	}

	public String getEnable() {
		return enable;
	}

	public String getStart() {
		return start;
	}

	public String getRestart() {
		return restart;
	}

	public String getStop() {
		return stop;
	}

}
