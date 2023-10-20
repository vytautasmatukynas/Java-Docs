
public class Main {

	public static void main(String[] args) {

		// constant
		System.out.println(Constants.DEFAULT);
		System.out.println(Constants.RED + "\n");

		// ENUM with final
		EnumsFinal importEnumFinal = EnumsFinal.DEFAULT;
		EnumsFinal importEnumFinal1 = EnumsFinal.RED;

		System.out.println(importEnumFinal.getSpalva());
		System.out.println(importEnumFinal1.getSpalva() + "\n");

		// ENUM without final
		Enums importEnum = Enums.DEFAULT;

		System.out.println(importEnum.getSpalva());

	}

}
