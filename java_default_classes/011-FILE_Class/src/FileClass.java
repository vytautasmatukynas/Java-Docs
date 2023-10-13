import java.io.File;
import java.io.IOException;
import java.sql.Date;


/**
 * reading and writing data to and from files
 * working with files and dir's
 */

public class FileClass {

	public static void main(String[] args) {

		// File
		newFile();

		existsFile();

		isFileCheck();

		deleteFile();

		existsFile();

		newFile(); // create new file because it was deleted

		renameFile();

		System.out.println();

		newFile(); // create new file because it was renamed

		getFileName();

		getAbsolutePath();

		getRelativePath();

		getParentPath();

		lastModifiedFileDate();

		System.out.println();

		isFileReadable();

		isFileWritable();

		getFileBytesLen();

		System.out.println();

		// Directory
		createDir();

		existsDir();

		createDirWithChildDir();

		ifDirCheck();

		deleteDir();

		renameDir();

		lastModifiedDirDate();

		System.out.println();

		// Something else
		createTempFile();

		fileFolderListInDir();

		getRootDirs();

		isHidden();

		fileSample();

	}

	private static void fileSample() {
		File file = new File("example.txt");
		if (file.exists()) {
			System.out.println("File exists.");
			if (file.canRead()) {
				System.out.println("File is readable.");
			}
			if (file.canWrite()) {
				System.out.println("File is writable.");
			}
			if (file.canExecute()) {
				System.out.println("File is executable.");
			}
		} else {
			System.out.println("File does not exist.");
		}
	}

	private static void createTempFile() {
		try {
			File tempFile = File.createTempFile("temp", ".txt");
			System.out.println("Temporary file path: " + tempFile.getAbsolutePath());
		} catch (IOException e) {
			e.getLocalizedMessage();
		}
	}

	private static void isHidden() {
		File file = new File("example.txt");
		if (file.isHidden()) {
			System.out.println("File is hidden.");
		} else {
			System.out.println("File is not hidden.");
		}
	}

	private static void getRootDirs() {
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println("Root directory: " + root);
		}
	}

	private static void lastModifiedDirDate() {
		File dir = new File("parentDir");
		long lastModifiedTimestamp = dir.lastModified();
		Date lastModifiedDate = new Date(lastModifiedTimestamp);
		System.out.println("Last modified: " + lastModifiedDate);
	}

	private static void lastModifiedFileDate() {
		File file = new File("example.txt");
		long lastModifiedTimestamp = file.lastModified();
		Date lastModifiedDate = new Date(lastModifiedTimestamp);
		System.out.println("Last modified: " + lastModifiedDate);
	}

	private static void getFileBytesLen() {
		File file = new File("example.txt");
		long length = file.length();
		System.out.println("File length: " + length + " bytes");
	}

	private static void renameDir() {
		File oldName = new File("parentDir");
		File newName = new File("parentDirNew");
		if (oldName.exists()) {
			if (oldName.renameTo(newName)) {
				System.out.println("Dir renamed successfully.");
			} else {
				System.out.println("Failed to rename dir.");
			}
		} else {
			System.out.println("The old dir does not exist.");
		}
	}

	private static void renameFile() {
		File oldFile = new File("example.txt");
		File newFile = new File("newname.txt");
		if (oldFile.exists()) {
			if (oldFile.renameTo(newFile)) {
				System.out.println("File renamed successfully.");
			} else {
				System.out.println("Failed to rename file.");
			}
		} else {
			System.out.println("The old file does not exist.");
		}

		System.out.println();
	}

	private static void isFileWritable() {
		File file = new File("example.txt");
		if (file.canWrite()) {
			System.out.println("File is writable.");
		} else {
			System.out.println("File is not writable.");
		}
	}

	private static void isFileReadable() {
		File file = new File("example.txt");
		if (file.canRead()) {
			System.out.println("File is readable.");
		} else {
			System.out.println("File is not readable.");
		}
	}

	private static void existsDir() {
		File checkDir = new File("myNewDirectory");
		if (checkDir.exists()) {
			System.out.println("Directory exists.");
		} else {
			System.out.println("Directory does not exist.");
		}
	}

	private static void deleteDir() {
		File directory = new File("myNewDirectory");
		if (directory.delete()) {
			System.out.println("Directory deleted successfully.");
		} else {
			System.out.println("Failed to delete directory.");
		}
	}

	private static void fileFolderListInDir() {
		File directory = new File("D:\\Java\\java_default\\010-FILE_Class");
		File[] files = directory.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

	private static void isFileCheck() {
		File directory = new File("example.txt");
		if (directory.isFile()) {
			System.out.println("It's a file.");
		} else {
			System.out.println("It's not a file.");
		}
	}

	private static void ifDirCheck() {
		File directory = new File("myNewDirectory");
		if (directory.isDirectory()) {
			System.out.println("It's a directory.");
		} else {
			System.out.println("It's not a directory.");
		}
	}

	private static void createDirWithChildDir() {
		String directoryPath = "parentDir/childDir";

		// Create a File object for the new directory and its parent directories
		File directory = new File(directoryPath);

		// Create the directory and its parent directories if they don't exist
		if (directory.mkdirs()) {
			System.out.println("Directory '" + directoryPath + "' and its parent directories created successfully.");
		} else {
			System.out.println("Failed to create directory '" + directoryPath + "'.");
		}
	}

	private static void createDir() {
		String directoryName = "myNewDirectory";

		// Create a File object for the new directory
		File directory = new File(directoryName);

		// Create the directory
		if (directory.mkdir()) {
			System.out.println("Directory '" + directoryName + "' created successfully.");
		} else {
			System.out.println("Failed to create directory '" + directoryName + "'.");
		}
	}

	private static void getParentPath() {
		File file = new File("example.txt");
		String parentPath = file.getParent();
		System.out.println("File name: " + parentPath);
	}

	private static void getRelativePath() {
		File file = new File("example.txt");
		String relativePath = file.getPath();
		System.out.println("File name: " + relativePath);
	}

	private static void getAbsolutePath() {
		File file = new File("example.txt");
		String absPath = file.getAbsolutePath();
		System.out.println("File name: " + absPath);
	}

	private static void getFileName() {
		File file = new File("example.txt");
		String fileName = file.getName();
		System.out.println("File name: " + fileName);
	}

	private static void deleteFile() {
		File fileToDelete = new File("example.txt");
		boolean deleted = fileToDelete.delete();
		if (deleted) {
			System.out.println("File deleted successfully.");
		} else {
			System.out.println("File not found or could not be deleted.");
		}
	}

	private static void existsFile() {
		File checkFile = new File("example.txt");
		if (checkFile.exists()) {
			System.out.println("File exists.");
		} else {
			System.out.println("File does not exist.");
		}
	}

	private static void newFile() {
		File newFile = new File("example.txt");

		try {
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}

		if (!newFile.exists()) {
			System.out.println("File created successfully.");
		} else {
			System.out.println("File already exists.");
		}
	}

}
