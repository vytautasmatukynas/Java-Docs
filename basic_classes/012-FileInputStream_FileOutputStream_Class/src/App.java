import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * reading and writing data to and from files
 * typically used when you need to work with raw binary data, like images, audio files, or any other non-textual data
 */
public class App {

	public static void main(String[] args) {
		
        File file = newFile();
        
        inputStream(file);

//      OutputStream is an abstract class used for writing binary data to various destinations, such as files, network sockets, or in-memory byte arrays.
//      It provides methods for writing data in a byte-by-byte or block-by-block manner.
        outputStream(file);
        
//      InputStream is an abstract class used for reading binary data from various sources, such as files, network sockets, or in-memory byte arrays.
//      It provides methods for reading data in a byte-by-byte or block-by-block manner.
        inputStream(file);

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

	
	private static void outputStream(File file) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            // Data to be written to the file
            String data = "Hello, World!";
            
            // Convert the string to bytes and write it to the file
            byte[] bytes = data.getBytes();
            
            fileOutputStream.write(bytes);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	private static void inputStream(File file) {
		try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int data;
            
            // Read bytes from the file until the end of the file is reached
            while ((data = fileInputStream.read()) != -1) {
                // Process the byte data (e.g., print it)
                System.out.print((char) data);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
