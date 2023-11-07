import java.util.ArrayList;

public class WeatherData {

	private Station station;
	private ArrayList<Observation> observations;

	public WeatherData(Station station, ArrayList<Observation> observations) {
		this.station = station;
		this.observations = observations;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public ArrayList<Observation> getObservations() {
		return observations;
	}

	public void setObservations(ArrayList<Observation> observations) {
		this.observations = observations;
	}
	
	@Override
	public String toString() {
		return "Stations [station=" + station + ", observations=" + observations + "]";
	}


	public class Coordinates {
		private double latitude;
		private double longitude;

		public Coordinates(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		@Override
		public String toString() {
			return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
		}
		
	}

}
