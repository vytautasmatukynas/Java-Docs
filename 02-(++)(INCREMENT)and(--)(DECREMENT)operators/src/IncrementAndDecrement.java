
// Perform increment (++) and decrement (--) operators
public class IncrementAndDecrement {

	public static void main(String[] args) {
		int a = 20;
		int b = 9;
		// skaito koda is kaires i desine del to pirmam variante pirma paraso reiksme
		// o tik poto prideda, del to sekanti "a" matai prideta, o "c" matai ta pati
		// kaip buvo pirmiau.
		int c = a++;

		// antram variante pirma prideda, o poto paraso reiksme.
		// del to pasikeicia ir "b" nes prideda viena ir "d" nes raso iskart prideta "b"
		// reiksme.
		int d = ++b;

		System.out.println("A: " + a);
		System.out.println("C: " + c);

		System.out.println("B: " + b);
		System.out.println("D: " + d);

		a++;
		b++;

		System.out.println("A++: " + a);
		System.out.println("B++: " + b);

		++a;
		++b;

		System.out.println("++A: " + a);
		System.out.println("++B: " + b);

	}

}
