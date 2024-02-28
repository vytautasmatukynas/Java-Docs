package linux.ubuntu.postgres.panel.postgres.commands;

/**
 * Constants for PSQL status and version command lines
 */
public enum StatusPsqlCommand {

	STATUS_PSQL("psql --version", 
			"systemctl status postgresql");

	private final String version;
	private final String status;

	private StatusPsqlCommand(String version, String status) {
		this.version = version;
		this.status = status;
	}

	public String getVersion() {
		return version;
	}

	public String getStatus() {
		return status;
	}
}
