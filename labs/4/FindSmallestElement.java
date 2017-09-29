//7.9

import java.util.Scanner;

public class FindSmallestElement {

	public static void main(String[] args) {
		// Get input from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 numbers: ");
		
		double[] numbers = new double[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}
		
		System.out.println("The minimum number is: " + min(numbers));

	}
	
	public static double min(double[] array) {
		double min = array[0];
		for (double i: array) {
			if (i < min)
				min = i;
		}
		return min;
	}

}
