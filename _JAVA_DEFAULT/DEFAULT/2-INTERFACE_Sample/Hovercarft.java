
public class Hovercarft implements IsLandVehicle, IsSeaVessel {

	String name;
	int maxPassanger;
	int maxSpeed;
	int numWheels;
	int displacement;

	public Hovercarft(String name, int maxPassanger, int maxSpeed, int numWheels, int displacement) {
		this.name = name;
		this.maxPassanger = maxPassanger;
		this.maxSpeed = maxSpeed;
		this.numWheels = numWheels;
		this.displacement = displacement;
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
		return maxPassanger;
	}

	@Override
	public void setMaxPassenger(int maxPassanger) {
		this.maxPassanger = maxPassanger;
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
	public int getDisplacement() {
		return displacement;
	}

	@Override
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	@Override
	public void launch() {
		System.out.println("Can launch on water");

	}

	@Override
	public void drive() {
		System.out.println("Can drive on land");

	}

	public void enterWater() {
		System.out.println("can enter to water and launch");
	}

	public void enterLand() {
		System.out.println("can enter and drive on land");
	}

	@Override
	public String toString() {
		return "Hovercarft [name=" + name + ", maxPassanger=" + maxPassanger + ", maxSpeed=" + maxSpeed + ", numWheels="
				+ numWheels + ", displacement=" + displacement + "]";
	}

}
