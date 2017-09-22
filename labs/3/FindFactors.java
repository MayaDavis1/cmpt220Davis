//5.16

import java.util.Scanner; 

public class FindFactors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Get integer from user
		System.out.println("Enter an integer: ");
		int number = input.nextInt();
		int index = 2; 
		
		// Find and display smallest factors in increasing order
		while (number / index != 1) {
			if (number % index == 0) {
				System.out.print(index + ", ");
				number /= index;
			}
			else 
				index++; 
		}
		System.out.println(number + ".");
	}

}
