//11.1
import java.util.Scanner;

public class TestTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Get input sides from user
		System.out.println("Enter three sides of a triangle: "); 
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		// Get color
		System.out.printf("Enter the color of the triangle: ");
		String color = input.next();
		// Get filled/unfilled
		System.out.println("Is the triangle filled (true/false): ");
		String f1 = input.next();
		boolean isFilled = (f1.equals("true"));
		
		Triangle triangle = new Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(isFilled);
		// Output
		System.out.println("Triangle: " + triangle.toString());
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Is filled? " + triangle.isFilled());
		
	}

}
