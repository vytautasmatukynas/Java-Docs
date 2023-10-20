
public class LogicalOperatorsBasic {

	public static void main(String[] args) {

		int skaicius_1 = 5;
		int skaicius_2 = 6;

		not();
		and(skaicius_1, skaicius_2);
		or(skaicius_1, skaicius_2);

	}

	private static void not() {
		// ! yra NOT. Galima naudoti tik su BOOLEAN
		boolean logicalNotResult = !true;
		System.out.println("Logical NOT: " + logicalNotResult);
	}

	private static void and(int skaicius_1, int skaicius_2) {
		// && yra AND. & irgi yra AND
		// && nustoja tikrinti suradus false
		// & tikrina viska iki galo, kad ir rado false
		if (skaicius_1 == 5 && skaicius_2 == 5) {
			System.out.println("Abidvi reiksmes patikrino ir visos tinka");
		} else if (skaicius_1 == 5 & skaicius_2 == 5) {
			System.out.println("Abidvi reiksmes patikrino ir visos tinka");
		} else {
			System.out.println("Nerado bent vienos reiksmes");
		}
	}

	private static void or(int skaicius_1, int skaicius_2) {
		// || yra OR. | irgi yra OR
		// || nustoja tikrinti suradus true
		// | tikrina viska iki galo, kad ir rado true
		if (skaicius_1 == 5 || skaicius_2 == 5) {
			System.out.println("Rado bent viena reiksme ir sustojo ties ja ieskoti");
		} else if (skaicius_1 == 5 | skaicius_2 == 5) {
			System.out.println("Rado bent viena reiksme ir sustojo ties ja ieskoti");
		} else {
			System.out.println("Nerado reiksmes");
		}
	}

}
