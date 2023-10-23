import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import com.github.javafaker.Faker;
import com.google.gson.Gson;


public class App {

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		Gson gson = new Gson();

		listToJson(faker, gson);
		System.out.println();
		setToJson(faker, gson);
		System.out.println();
		mapToJson(faker, gson);
		System.out.println();
		arrayToJson(faker, gson);
		
		System.out.println();
		
		readJsonToList("jsonFiles/arrayToJson.json");
		System.out.println();
		readJsonToList("jsonFiles/setToJson.json");
		System.out.println();
		readJsonToList("jsonFiles/listToJson.json");
		System.out.println();
		readJsonToMap("jsonFiles/mapToJson.json");
		
		jsonUsingObject(faker, gson);
		readJsonObject("jsonFiles/stringBuilderToJsonObject.json");
		System.out.println();
		jsonUsingObjectWithArray(faker, gson);
		readJsonObjectWithArray("jsonFiles/stringBuilderToJsonObjectWithArray.json");
		System.out.println();
		jsonUsingArray(faker, gson);
		readJsonArray("jsonFiles/stringBuilderToJsonArray.json");
		
		System.out.println();
		
		readWriteUpdateJsonMap("jsonFiles/mapToJson.json", faker, gson);
		System.out.println();
		readWriteUpdateJsonList("jsonFiles/listToJson.json", faker, gson);
		
	}

	
	private static void readWriteUpdateJsonList(String fileName, Faker fakeData, Gson gson) {
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		
		List<Student> studentai = FileHandler.readJsonAsList(fileName, Student.class);
		
		studentai.stream()
				.forEach(student -> System.out.println(String.format
						("Vardas: %s | Amzius: %s | Universitetas: %s", 
								student.getName(), student.getAge(), student.getStudying())));
		
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));

		String json = gson.toJson(studentai);
		
		System.out.println();
		
		System.out.println(json);
		
		FileHandler.saveToFile(json, fileName);
		
		List<Student> studentaiAfterUpdate = FileHandler.readJsonAsList(fileName, Student.class);
		
		System.out.println();
		
		studentaiAfterUpdate.stream()
				.forEach(student -> System.out.println(String.format
						("Vardas: %s | Amzius: %s | Universitetas: %s", 
								student.getName(), student.getAge(), student.getStudying())));
	}
	
	
	private static void readWriteUpdateJsonMap(String fileName, Faker fakeData, Gson gson) {
		int id = new Random().nextInt(1, 100000);
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		Map<Integer, Student> studentai = FileHandler.readJsonAsMap(fileName, Integer.class, Student.class);

		studentai.forEach((key, value) -> System.out.println(
				String.format("Studento ID: %s\n\tVardas: %s\n\tAmzius: %s\n\tUniversitetas: %s\n\t", 
						key, value.getName(), value.getAge(), value.getAge())));
		
		studentai.put(id, new Student(name, age, university));

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/mapToJson.json");
		
		Map<Integer, Student> studentaiAfterUpdate = FileHandler.readJsonAsMap(fileName, Integer.class, Student.class);

		studentaiAfterUpdate.forEach((key, value) -> System.out.println(
				String.format("Studento ID: %s\n\tVardas: %s\n\tAmzius: %s\n\tUniversitetas: %s\n\t", 
						key, value.getName(), value.getAge(), value.getAge())));
	}
	

	private static void readJsonArray(String fileName) {
		List<StudentsList> studentai = FileHandler.readJsonAsList(fileName, StudentsList.class);
		
		studentai.stream()
				.forEach(student -> System.out.println(String.format
													("Vardas: %s | Amzius: %s | Universitetas: %s", 
															student.getStudent().get(0).getName(), 
															student.getStudent().get(0).getAge(), 
															student.getStudent().get(0).getStudying())));
	}

	
	private static void jsonUsingArray(Faker fakeData, Gson gson) {
		int id = new Random().nextInt(1, 100000);
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		ArrayList<Student> studentas = new ArrayList<>(List.of(new Student(name, age, university)));
		
		ArrayList<StudentsList> studentai = new ArrayList<>(List.of(new StudentsList(id, studentas)));

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/stringBuilderToJsonArray.json");
	}
	
	
	private static void readJsonObjectWithArray(String fileName) {
		Optional<StudentsList> studentai = FileHandler.readJsonAsObject(fileName, StudentsList.class);
		
		if (studentai.isPresent())
			studentai.stream()
				.forEach(student -> System.out.println(String.format
													("Vardas: %s | Amzius: %s | Universitetas: %s", 
															student.getStudent().get(0).getName(), 
															student.getStudent().get(0).getAge(), 
															student.getStudent().get(0).getStudying())));
	}
	
	
	private static void jsonUsingObjectWithArray(Faker fakeData, Gson gson) {
		int id = new Random().nextInt(1, 100000);
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		ArrayList<Student> studentas = new ArrayList<>(List.of(new Student(name, age, university)));
		
		StudentsList studentai = new StudentsList(id, studentas);

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/stringBuilderToJsonObjectWithArray.json");
	}
	
	
	private static void readJsonObject(String fileName) {
		Optional<Students> studentai = FileHandler.readJsonAsObject(fileName, Students.class);
		
		if (studentai.isPresent())
			studentai.stream()
					.forEach(student -> System.out.println(String.format
														("Vardas: %s | Amzius: %s | Universitetas: %s", 
																student.getStudent().getName(), 
																student.getStudent().getAge(), 
																student.getStudent().getStudying())));
	}
	
	
	private static void jsonUsingObject(Faker fakeData, Gson gson) {
		int id = new Random().nextInt(1, 100000);
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		Student studentas = new Student(name, age, university);
		
		Students studentai = new Students(id, studentas);

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/stringBuilderToJsonObject.json");
	}
	
	
	private static void readJsonToMap(String fileName) {
		Map<Integer, Student> studentai = FileHandler.readJsonAsMap(fileName, Integer.class, Student.class);

		studentai.forEach((key, value) -> System.out.println(
				String.format("Studento ID: %s\n\tVardas: %s\n\tAmzius: %s\n\tUniversitetas: %s\n\t", 
						key, value.getName(), value.getAge(), value.getAge())));
	}
	

	private static void readJsonToList(String fileName) {
		List<Student> studentai = FileHandler.readJsonAsList(fileName, Student.class);
		
		studentai.stream()
				.forEach(student -> System.out.println(String.format
						("Vardas: %s | Amzius: %s | Universitetas: %s", 
								student.getName(), student.getAge(), student.getStudying())));
	}

	
	private static void arrayToJson(Faker fakeData, Gson gson) {
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		Student studentas1 = new Student(name, age, university);
		Student studentas2 = new Student(name, age, university);
		Student studentas3 = new Student(name, age, university);
		
		Student[] studentai = {studentas1, studentas2, studentas3};

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/arrayToJson.json");
		
		
	}

	
	private static void mapToJson(Faker fakeData, Gson gson) {
		int id = new Random().nextInt(1, 100000);
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		Map<Integer, Student> studentai = new HashMap<>();
		
		studentai.put(id, new Student(name, age, university));
		studentai.put(id, new Student(name, age, university));
		studentai.put(id, new Student(name, age, university));

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/mapToJson.json");
	}
	

	private static void setToJson(Faker fakeData, Gson gson) {
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		Set<Student> studentai = new HashSet<>();
		
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/setToJson.json");
	}
	

	private static void listToJson(Faker fakeData, Gson gson) {
		String name = fakeData.name().firstName();
		long age = fakeData.number().numberBetween(19, 35);
		String university = fakeData.educator().university();
		
		List<Student> studentai = new ArrayList<>();
		
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));
		studentai.add(new Student(name, age, university));

		String json = gson.toJson(studentai);
		System.out.println(json);
		
		FileHandler.saveToFile(json, "jsonFiles/listToJson.json");
	}

}
