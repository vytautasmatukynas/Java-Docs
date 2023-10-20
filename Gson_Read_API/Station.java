public class Station {
	
    public String code;
    public String name;
    public Coordinates coordinates;

	public Station(String code, String name, Coordinates coordinates) {
		this.code = code;
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Station [code=" + code + ", name=" + name + ", coordinates=" + coordinates + "]";
	}

}