//7.15

import java.util.Scanner;

public class EliminateDuplicates {

	public static void main(String[] args) {
		// Get integers from user
		Scanner input = new Scanner(System.in); 
		int[] numbers = new int[10];
		System.out.println("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = input.nextInt();
		
		// Get distinct numbers
		int[] distinctNumbers = eliminateDuplicates(numbers);
		
		// Output
		System.out.print("The distinct numbers are: ");
		for (int e: distinctNumbers) {
			if (e > 0)
				System.out.print(" " + e);
		}
		
		System.out.println();

	}

	private static int[] eliminateDuplicates(int[] list) {
		int[] distinctList = new int[list.length];
		int i = 0;
		for (int e: list) {
			if (linearSearch(distinctList, e) == -1) {
				distinctList[i] = e;
				i++;
			}
		}
		return distinctList;
	}

	private static int linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				return i;
		}
		return -1;
	}

}
