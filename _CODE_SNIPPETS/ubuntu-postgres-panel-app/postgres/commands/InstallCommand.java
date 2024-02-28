package linux.ubuntu.postgres.panel.postgres.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Constants for PSQL install command lines
 */
public enum InstallCommand {

	INSTALL("wget -qO /etc/apt/trusted.gpg.d/pgdg.asc https://www.postgresql.org/media/keys/ACCC4CF8.asc",
			"echo deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -sc)-pgdg main -y", 
			"apt update -y",
			"apt install -y postgresql postgresql-contrib");

	private String gpg_key;
	private String repo;
	private String[] install;

	private InstallCommand(String gpg_key, String repo, String... install) {
		this.gpg_key = gpg_key;
		this.repo = repo;
		this.install = install;
	}

	public String getGpgKey() {
		return gpg_key;
	}

	public String getRepo() {
		return repo;
	}

	public String[] getInstall() {
		return install;
	}

	public List<String> allCommands() {
		List<String> allCommands = new ArrayList<>();

		allCommands.add(gpg_key);
		allCommands.add(repo);
		allCommands.add(install[0]);
		allCommands.add(install[1]);

		return allCommands;
	}

}
