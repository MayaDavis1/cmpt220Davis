//12.3
import java.util.Scanner;
public class OutOfBounds {

	public static void main(String[] args) {
		
		// Create array with 100 random numbers
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
			
			// Get input from user
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an index to the array: ");
		
			try {
				int idx = input.nextInt();
				System.out.println("array[" + idx + "] is " + array[idx]);
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("Out of bounds");
			}
		}
		

	}


