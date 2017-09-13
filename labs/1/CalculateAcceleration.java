//2.9

import java.util.Scanner;

public class CalculateAcceleration {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	//Prompt for v0, v1, and t
	System.out.println(" Enter v0, v1, and t: ");
	double v0 = input.nextDouble();
	double v1 = input.nextDouble();
	double t = input.nextDouble();
	
	//Calculate average acceleration
	double AverageAcceleration = (( v1 - v0) / t );
	
	//Output 
	System.out.println(" The average acceleration is " + AverageAcceleration );

	}

}
