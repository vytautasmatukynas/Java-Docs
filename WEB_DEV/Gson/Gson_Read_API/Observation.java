public class Observation {

	private String observationTimeUtc;
	private double airTemperature;
	private double feelsLikeTemperature;
	private double windSpeed;
	private double windGust;
	private int windDirection;
	private int cloudCover;
	private double seaLevelPressure;
	private int relativeHumidity;
	private double precipitation;
	private String conditionCode;

	public Observation(String observationTimeUtc, double airTemperature, double feelsLikeTemperature, double windSpeed,
			double windGust, int windDirection, int cloudCover, double seaLevelPressure, int relativeHumidity,
			double precipitation, String conditionCode) {

		this.observationTimeUtc = observationTimeUtc;
		this.airTemperature = airTemperature;
		this.feelsLikeTemperature = feelsLikeTemperature;
		this.windSpeed = windSpeed;
		this.windGust = windGust;
		this.windDirection = windDirection;
		this.cloudCover = cloudCover;
		this.seaLevelPressure = seaLevelPressure;
		this.relativeHumidity = relativeHumidity;
		this.precipitation = precipitation;
		this.conditionCode = conditionCode;
	}

	public String getObservationTimeUtc() {
		return observationTimeUtc;
	}

	public void setObservationTimeUtc(String observationTimeUtc) {
		this.observationTimeUtc = observationTimeUtc;
	}

	public double getAirTemperature() {
		return airTemperature;
	}

	public void setAirTemperature(double airTemperature) {
		this.airTemperature = airTemperature;
	}

	public double getFeelsLikeTemperature() {
		return feelsLikeTemperature;
	}

	public void setFeelsLikeTemperature(double feelsLikeTemperature) {
		this.feelsLikeTemperature = feelsLikeTemperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindGust() {
		return windGust;
	}

	public void setWindGust(double windGust) {
		this.windGust = windGust;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}

	public int getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(int cloudCover) {
		this.cloudCover = cloudCover;
	}

	public double getSeaLevelPressure() {
		return seaLevelPressure;
	}

	public void setSeaLevelPressure(double seaLevelPressure) {
		this.seaLevelPressure = seaLevelPressure;
	}

	public int getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(int relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}

	@Override
	public String toString() {
		return "Observation [observationTimeUtc=" + observationTimeUtc + ", airTemperature=" + airTemperature
				+ ", feelsLikeTemperature=" + feelsLikeTemperature + ", windSpeed=" + windSpeed + ", windGust="
				+ windGust + ", windDirection=" + windDirection + ", cloudCover=" + cloudCover + ", seaLevelPressure="
				+ seaLevelPressure + ", relativeHumidity=" + relativeHumidity + ", precipitation=" + precipitation
				+ ", conditionCode=" + conditionCode + "]";
	}

}