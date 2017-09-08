import java.util.Scanner;

public class ComputeArea {
	public static void main(String[] args) {
		double radius; //Declare Radius
		double area; //Declare area
		Scanner input; //Input variable
		
		System.out.print("Enter a double value for the radius: ");
		input = new Scanner(System.in);
		radius = input.nextDouble();
		
		
		//Compute area
		area = 3.14159 * radius * radius; 
		
		System.out.println(" The area for the circle of radius " + radius + 
				" is " + area);
		
	}
}