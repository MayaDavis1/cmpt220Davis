//18.11
import java.util.Scanner;

public class Sum {
	
	public static void main(String[] args) {
		//Get input from user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		long n = input.nextLong();
		
		// Output
		System.out.println("The sum of the digits in the number " + n + " is " + sumDigits(n));
		
	}
	
	public static int sumDigits(long n) {
		return sumDigits(n, 0);
	}
		// Find the sum of the digits
	public static int sumDigits(long n, int sum) {
		if (n == 0) {
			return sum;
		} else {
			sum += (n% 10);
			return sumDigits(n / 10, sum);
		}
	}

}
