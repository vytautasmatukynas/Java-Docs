package linux.ubuntu.postgres.panel.postgres.terminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import linux.ubuntu.postgres.panel.ui.Color;


public class ExecuteCommand {

	public static void sudo(String command) {
		try {
			// INPUT. Create a ProcessBuilder for the command you want to execute in terminal
			// Sends to terminal external command or script that you want to execute in the terminal
			ProcessBuilder inputProcess = new ProcessBuilder("sudo " + command);

			startCommand(inputProcess);

		} catch (IOException | InterruptedException error) {
			error.printStackTrace();
		}
	}
	

	public static void echoSudoS(String password, String command) {
		try {
			// INPUT. Create a ProcessBuilder for the command you want to execute in terminal
			// Sends to terminal external command or script that you want to execute in the terminal
			ProcessBuilder inputProcess = new ProcessBuilder("echo " + password + " | sudo -S " + command);

			startCommand(inputProcess);

		} catch (IOException | InterruptedException error) {
			error.printStackTrace();
		}
	}
	

	private static void startCommand(ProcessBuilder inputProcess) throws IOException, InterruptedException {
	
		// Start the 'ProcessBuilder' process
		Process startInputProcess = inputProcess.start();

		// Reads the standard output stream
		// Contains the output produced by the command executed in the terminal
		// OUTPUT. Get output from terminal after executing command in terminal with 'InputStreamReader'
		InputStreamReader getOutputFromProcess = new InputStreamReader(startInputProcess.getInputStream());
		
		// Can read lines directly from 'InputStreamReader', but 'BufferedReader' provides better performance and buffering,
		// especially when reading text data line by line.
		// Allows you to efficiently read text lines from the process's standard output stream
		// Read the OUTPUT from the 'InputStreamReader'
		BufferedReader reader = new BufferedReader(getOutputFromProcess);

		String line;
		// 'readLine()' method returns 'null' when it reaches the end of the input stream
		// 'line = reader.readLine()' reads a line of text from the 'BufferedReader'
		// reads till it's not 'null'
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		// Wait for the process to complete
		// 'waitFor()' method will block the current thread until the external process
		// (startInputProcess in this case) completes its execution and then it will print out last line
		startInputProcess.waitFor();
		System.out.println(Color.GREEN + "\n\nCommand finished.\n\n" + Color.DEFAULT);
		
	}

}