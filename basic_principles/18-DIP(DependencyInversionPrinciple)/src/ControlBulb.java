
public class ControlBulb {
	
	private Switchable bulb;
	
	
    public ControlBulb(Switchable bulb) {
		this.bulb = bulb;
	}

	public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}
