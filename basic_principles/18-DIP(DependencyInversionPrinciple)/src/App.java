
public class App {

	public static void main(String[] args) {

		ControlBulb controlLED = new ControlBulb(new BulbLED());
		ControlBulb controlNormal = new ControlBulb(new BulbNormal());
		
		controlLED.turnOn();
		controlLED.turnOff();
		
		controlNormal.turnOn();
		controlNormal.turnOff();

	}

}
