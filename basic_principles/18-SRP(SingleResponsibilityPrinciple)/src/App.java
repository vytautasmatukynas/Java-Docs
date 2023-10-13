
public class App {

	public static void main(String[] args) {
		Report report = new Report();
		String data = report.generateReport("OOOO");
		
		Printer.printReport(data);

	}

}
