import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * reading and writing data to and from files
 * working with textual data, such as reading and writing text files
 */
public class App {

	public static void main(String[] args) {
		
		File file = newFile();
		
		reader(file); 
		
//		The write method is used to write a single character, a portion of a character array, or a string to the output stream.
//		It is called with a single argument, which can be a character, a character array, or a string.
//		When you call write, it writes the specified data immediately to the output stream.
//		If false, overwrite data.
		writerFalse(file);
		
		reader(file); 
		
//		The write method is used to write a single character, a portion of a character array, or a string to the output stream.
//		It is called with a single argument, which can be a character, a character array, or a string.
//		When you call write, it writes the specified data immediately to the output stream.
//		If true, append data.
		writerTrue(file);
		
		reader(file); 
		
//		Adds new line. Same as pressing "ENTER".
		writerNewLine(file);
		
		reader(file); 
		
		writerAppend(file);
		
		reader(file); 

	}



	private static void writerAppend(File file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			
			bufferedWriter.append("Line 3");
			
			bufferedWriter.newLine(); // Adds a newline character
			
			bufferedWriter.append("Line 4");
			
			bufferedWriter.newLine(); // Adds a newline character

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	private static void writerNewLine(File file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			
			bufferedWriter.write("Line 1");
			
			bufferedWriter.newLine(); // Adds a newline character
			
			bufferedWriter.write("Line 2");
			
			bufferedWriter.newLine(); // Adds a newline character

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File newFile() {
		File file = new File("example.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	private static void writerTrue(File file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
			bufferedWriter.write("AAAA");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writerFalse(File file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			bufferedWriter.write("\tEEEE");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void reader(File file) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				System.out.println(line);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
