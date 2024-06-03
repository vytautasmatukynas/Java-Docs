import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<IsVehicle> vehicles = new ArrayList<>();

		vehicles.add(new Jeep("Audi", 7, 240, 4));
		vehicles.add(new Jeep("Suzuki", 5, 180, 4));
		vehicles.add(new Jeep("Skoda", 5, 220, 4));
		vehicles.add(new Hovercarft("SomeName", 8, 100, 8, 25));
		vehicles.add(new Frigate("SooomeName", 10, 150, 75));

		extracted(vehicles);

	}

	private static void extracted(List<IsVehicle> list) {

		for (IsVehicle vehicle : list) {
			if (vehicle instanceof Jeep) {
				((Jeep) vehicle).drive();
				((Jeep) vehicle).soundHorn();
				System.out.println(((Jeep) vehicle).toString());
				System.out.println();
			} else if (vehicle instanceof Hovercarft) {
				((Hovercarft) vehicle).drive();
				((Hovercarft) vehicle).launch();
				((Hovercarft) vehicle).enterLand();
				((Hovercarft) vehicle).enterWater();
				System.out.println(((Hovercarft) vehicle).toString());
				System.out.println();
			} else {
				((Frigate) vehicle).launch();
				((Frigate) vehicle).fireGun();
				System.out.println(vehicle.toString());
				System.out.println();
			}
		}

	}

}
