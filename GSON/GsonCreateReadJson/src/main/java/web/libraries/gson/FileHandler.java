package web.libraries.gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class FileHandler {
	

	private static File getFile(String fileName) {
		File file = new File(fileName);
		checkFolder(file);
			
		
		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	

	private static void checkFolder(File file) {
		File dir = new File(file.getParent());
		
		if (!dir.exists())
			try {
				dir.mkdir();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	public static void saveToFile(String json, String fileName) {
		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(getFile(fileName)))) {
			
			fileWriter.write(json);
			
			System.out.println("JSON saved to: " + getFile(fileName).getAbsolutePath());
			
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	
	public static <K, V> Map<K, V> readJsonAsMap(String fileName,Class<K> typeKey, Class<V> typeValue) {
	    try (JsonReader fileReader = new JsonReader(new FileReader(getFile(fileName)))) {
	    	
	        Gson gson = new Gson();

	        Type mapType = TypeToken.getParameterized(Map.class, typeKey, typeValue).getType();

	        return gson.fromJson(fileReader, mapType);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return new HashMap<>();
	}
	
	
	public static <T> List<T> readJsonAsList(String fileName, Class<T> type) {
		try (JsonReader fileReader = new JsonReader(new FileReader(getFile(fileName)))){
			
			Gson gson = new Gson();
			
			Type dataList = TypeToken.getParameterized(List.class, type).getType();
			
			return gson.fromJson(fileReader, dataList);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	
	public static <T> Optional<T> readJsonAsObject(String fileName, Class<T> type) {
		try (JsonReader fileReader = new JsonReader(new FileReader(getFile(fileName)))){
        	
        	return Optional.ofNullable(new Gson()
        			.fromJson(fileReader, type));
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		return Optional.empty();
	}

}
