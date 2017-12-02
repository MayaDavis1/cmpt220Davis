//18.15
import java.util.Scanner;

public class Occurances {

	public static void main(String[] args) {
		// Get input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		System.out.print("Enter a character: ");
		char ch = input.nextLine().charAt(0);
		int times = count(s, ch);
		System.out.println(ch + " appears " + times + 
				(times > 1 ? " times " : " time ") + "in " + s);
	}

	private static int count(String str, char a) {
		return count(str, a, str.length() - 1);
	}
	
	// Helper method
	public static int count(String str, char a, int high) {
		if (high < 0)
			return 0;
		else if (str.charAt(high) == a)
			return 1 + count(str, a, high - 1);
		else
			return count(str, a, high - 1);
	}

}
