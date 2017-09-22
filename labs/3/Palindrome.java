//6.3

import java.util.Scanner; 

public class Palindrome {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		
		// Get integer from user
		System.out.println("Enter an integer: ");
		int number = input.nextInt();
		
		// Output
		System.out.println(number + (isPalindrome(number) ? " is " : " is not ") 
				+ "a palindrome.");

	}

	private static boolean isPalindrome(int number) {
		return number == reverse(number) ? true : false; 
	}

	private static int reverse(int number) {
		String reverse = "";
		String n = number + "";
		for (int i = n.length() - 1; i >= 0; i--) {
			reverse += n.charAt(i);
		}
		return Integer.parseInt(reverse);
	}

}
