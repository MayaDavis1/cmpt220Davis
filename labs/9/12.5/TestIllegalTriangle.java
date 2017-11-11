//12.5

import java.util.Scanner;
public class TestIllegalTriangle {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);

			// Prompt user to enter three sides of the triangle
			System.out.println("Enter three sides of a triangle: "); 
			double s1 = input.nextDouble();
			double s2 = input.nextDouble();
			double s3 = input.nextDouble();
	      
			Triangle t = new Triangle(s1, s2, s3);
			System.out.println("Tringle: " + t.toString());
			System.out.println("Area: " + t.getArea());
			System.out.println("Perimeter: " + t.getPerimeter());
			
	      } catch (IllegalTriangleException ex) {
	     	  System.out.println(ex);
	      }
		
		
	  }

		
}
