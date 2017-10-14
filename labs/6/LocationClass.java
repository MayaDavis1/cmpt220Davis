//9.13
import java.util.Scanner;
public class LocationClass {

	public static void main(String[] args) {
		// Get input from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns in the array: ");
		int row = input.nextInt();
		int column = input.nextInt();
		double[][] matrix = new double[row][column];
		
		// Store numbers
		System.out.println("Enter the array: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = input.nextDouble();
			}
		}
		
		// Output
		Location location = Location.locateLargest(matrix);
		System.out.println("The location of the largest element is " + location.maxValue + " at (" 
		+ location.row + ", " + location.column + ")");
		
		
	}
}
