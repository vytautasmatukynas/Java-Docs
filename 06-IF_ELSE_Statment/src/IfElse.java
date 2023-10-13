
public class IfElse {

	public static void main(String[] args) {

		ifInOneLine();
		salygaBeSkliausteliu();
		basicIf();
		darboLaikas();
		bilietuKaina();
		kluboKaina();
		bibliotekaNaryste();
		zvejybosLeidimas();

	}

	private static void salygaBeSkliausteliu() {
		// salyga tik su if arba tik su if ir else, galima rasyti be {}
		if (true)
			System.out.println("print");
		else
			System.out.println("dont print");
	}

	private static void ifInOneLine() {
		// if and else in one line
		int skaicius = 4;

		// kintamasis = salyga ? True : False
		String rezultatas = skaicius > 5 ? "Taip" : "Ne";

		System.out.println(rezultatas);
	}

	private static void zvejybosLeidimas() {
		boolean arTuriLeidima = true;
		boolean arSezonas = true;
		boolean arDraudimas = false;

		if (arTuriLeidima && arSezonas && arDraudimas) {
			System.out.println("galima zvejoti visiem");
		} else if (arTuriLeidima && !arSezonas && !arDraudimas) {
			System.out.println("turi leidima");
		} else if (arTuriLeidima && arSezonas && !arDraudimas) {
			System.out.println("turi leidima\n" + "sezonas prasidejo");
		} else if (arTuriLeidima && !arSezonas && arDraudimas) {
			System.out.println("turi leidima\n" + "sventine diena");
		} else if (!arTuriLeidima && arSezonas && !arDraudimas) {
			System.out.println("sezonas prasidejo");
		} else if (!arTuriLeidima && !arSezonas && arDraudimas) {
			System.out.println("sventine diena");
		} else if (!arTuriLeidima && arSezonas && arDraudimas) {
			System.out.println("sezonas prasidejo\n" + "sventine diena");
		} else {
			System.out.println("negalima zvejoti");
		}
	}

	private static void bibliotekaNaryste() {
		int skaitytojoTaskai = 101;
		boolean mokinys = false;

		if (skaitytojoTaskai > 100 || mokinys) {
			System.out.println("Premium naryste");
		} else {
			System.out.println("Basic naryste.");
		}
	}

	private static void kluboKaina() {

		int amzius = 70;
		int kaina = 15;
		boolean arPensininkas = amzius >= 65;
		boolean arNaujasNarys = true;

		if (arPensininkas && !arNaujasNarys) {
			System.out.println("Jusu kaina bus su 35%  nuolaida: " + (kaina * 0.65));
		} else if (!arPensininkas && !arNaujasNarys) {
			System.out.println("Jusu kaina bus pilna: " + (kaina));
		} else {
			System.out.println("Jusu kaina bus su 50% nuolaida: " + (kaina * 0.5));
		}
	}

	private static void bilietuKaina() {
		int amzius = 19;
		float kaina = 20;
		boolean arStudentas = true;

		if (amzius < 18 || arStudentas) {
			System.out.println("Jusu amzius yra " + amzius + ", tai kaina bus: " + (kaina / 2) + "euru");
		} else {
			System.out.println("Pilna suma: " + kaina);
		}
	}

	private static void darboLaikas() {
		int valanda = 15;
		int savaitgalio_diena = 5;

		boolean arDarboVal = 9 <= valanda && valanda <= 17;
		boolean arSavaitgalis = 1 <= savaitgalio_diena && savaitgalio_diena <= 5;

		if (arDarboVal && arSavaitgalis) {
			System.out.println("Eik i darba");
		} else {
			System.out.println("Sedek namie");
		}
	}

	private static void basicIf() {
		int amzius = 89;

		boolean tikrinti_amziu_1 = amzius < 25;
		boolean tikrinti_amziu_2 = amzius > 90;

		if (tikrinti_amziu_1) {
			System.out.println("per jaunas");
		} else if (tikrinti_amziu_2) {
			System.out.println("per senas");
		} else {
			System.out.println("Gali ieiti");
		}

		// OR CAN BE LIKE THIS
		int amzius_2 = 92;

		if (amzius_2 < 25) {
			System.out.println("per jaunas");
		} else if (amzius_2 > 90) {
			System.out.println("per senas");
		} else {
			System.out.println("Gali ieiti");
		}
	}

}
