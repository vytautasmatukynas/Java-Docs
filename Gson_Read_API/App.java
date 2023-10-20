import java.util.List;
import java.util.Optional;

public class App {

	public static void main(String[] args) {
		
		jsonAsList();
		
		System.out.println("\n----------------------\n");
		
		jsonAsObject();
		
	}

	private static void jsonAsObject() {
		String stationName = "kauno";
		String addrStations = String.format("https://api.meteo.lt/v1/stations/%s-ams/observations/latest", stationName);
		
		Optional<WeatherData> places = RequestHTTP.fetchDataAsObject(addrStations, WeatherData.class);
		
		if(places.isPresent()) {
			String name = places.get()
								.getStation()
								.getName();
			
			Double temp = places.get()
							    .getObservations()
							    .stream()
							    .mapToDouble(item -> item.getAirTemperature())
							    .average()
							    .orElse(0);

			System.out.println(String.format("Pavadinimas: %s | Temperatura: %.1f", name, temp));
		}
	}

	private static void jsonAsList() {
		String addrUrl = "https://api.meteo.lt/v1/places";
		
		List<Place> places = RequestHTTP.fetchDataAsList(addrUrl, Place.class);
		
		if (!places.isEmpty())
			places.forEach(data -> System.out.println(String.format("Pavadinimas: %s | "
																	+ "Administracija: %s | "
																	+ "Kodas: %s | Valstybes "
																	+ "kodas: %s", data.getName().replace(" AMS", ""), 
																					data.getAdministrativeDivision(), 
																					data.getCode(),
																					data.getCountryCode()
							)));
		else
		    System.out.println("Empty LIST");
		
		
		System.out.println("\n----------------------\n");
		
		
		if (!places.isEmpty())
			places.stream()
			.filter(miestas -> miestas.getName()
										.toLowerCase()
										.replace(" AMS", "")
										.contains("vilnius"))
			.forEach(data -> System.out.println(String.format("Pavadinimas: %s | "
															+ "Administracija: %s | "
															+ "Kodas: %s | Valstybes "
															+ "kodas: %s", data.getName().replace(" AMS", ""), 
																			data.getAdministrativeDivision(), 
																			data.getCode(),
																			data.getCountryCode()
	    			)));
		else
		    System.out.println("Empty LIST");
	}

}
