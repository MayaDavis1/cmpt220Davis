//18.17
import java.util.Scanner;

public class OccurancesArray {

	public static void main(String[] args) {
		// Get input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a list of characters in one line: ");
		String s = input.nextLine();
		char[] items = s.toCharArray();
		
		System.out.print("Enter a character: ");
		char ch = input.next().charAt(0);
		
		int times = count(items, ch);
		System.out.println(ch + " appears " + times + 
				(times > 1 ? " times " : " time ") + "in " + s);

	}

	private static int count(char[] chars, char ch) {
		return count(chars, ch, chars.length - 1);
	}

	private static int count(char[] chars, char ch, int high) {
		if (high < 0)
			return 0;
		else if (chars[high] == ch)
			return 1 + count(chars, ch, high - 1);
		else 
			return count(chars, ch, high - 1);
	}

}
