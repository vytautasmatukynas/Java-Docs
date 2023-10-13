
public class Frigate implements IsSeaVessel {

	String name;
	int maxPassenger;
	int maxSpeed;
	int displacement;

	public Frigate(String name, int maxPassenger, int maxSpeed, int displacement) {
		this.name = name;
		this.maxPassenger = maxPassenger;
		this.maxSpeed = maxSpeed;
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

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
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
		System.out.println("Can launch to water");

	}

	public void fireGun() {
		System.out.println("Can fire gun");
	}

	@Override
	public String toString() {
		return "Frigate [name=" + name + ", maxPassenger=" + maxPassenger + ", maxSpeed=" + maxSpeed + ", displacement="
				+ displacement + "]";
	}
	
	

}
