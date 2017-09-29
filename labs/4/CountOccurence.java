//7.3

import java.util.Scanner;

public class CountOccurence {

	public static void main(String[] args) {
		int[] counts = new int[100]; 
		// Get input from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the integers between 1 and 100: ");
		
		counts(counts);
		
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0)
				System.out.println((i + 1) + " occurs " + counts[i] + " time" 
			+ (counts[i] > 1 ? "s" : "")); 
		}
		
		}
	public static void counts(int[] counts) {
		Scanner input = new Scanner(System.in);
		int num;
		do {
			num = input.nextInt();
			if (num >= 1 && num <= 100)
				counts[num - 1]++;
		} while (num != 0);

	}

}
