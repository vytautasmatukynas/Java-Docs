
public class Jeep implements IsLandVehicle {

	String name;
	int maxPassenger;
	int maxSpeed;
	int numWheels;

	public Jeep(String name, int maxPassenger, int maxSpeed, int numWheels) {
		this.name = name;
		this.maxPassenger = maxPassenger;
		this.maxSpeed = maxSpeed;
		this.numWheels = numWheels;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getMaxPassenger() {
		return maxPassenger;
	}
	
	@Override
	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}

	@Override
	public int getMaxSpeed() {
		return maxSpeed;
	}

	@Override
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public int getNumWheels() {
		return numWheels;
	}

	@Override
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	@Override
	public void drive() {
		System.out.println("JEEP can drive.!! <<---- OU YES...");

	}
	
	public void soundHorn() {
		System.out.println("HORN SOUND! OOOOOUUUUUUOOOO....");
	}

	@Override
	public String toString() {
		return "Jeep [name=" + name + ", maxPassenger=" + maxPassenger + ", maxSpeed=" + maxSpeed + ", numWheels="
				+ numWheels + "]";
	}
	
	

}
