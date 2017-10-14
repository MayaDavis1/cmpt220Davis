//9.11
import java.util.Scanner;
public class LinearEquations {

	public static void main(String[] args) {
		// Get input from user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter value for a, b, c, d, e, and f: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		// Solve
		LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
		
		// Test inputs 
		if (equation.isSolvable()) {
			System.out.println("x is " + equation.getX());
			System.out.println("y is " + equation.getY());
		}
		else {
			System.out.println("The equation has no solution.");
		}
	}

}

	class LinearEquation {
		private double a;
		private double b;
		private double c;
		private double d;
		private double e;
		private double f;
		
		// Default Constructor
		public LinearEquation() {
		}
		
		public LinearEquation(double a1, double b1, double c1, double d1, double e1, double f1) {
			this.a = a1;
			this.b = b1;
			this.c = c1;
			this.d = d1;
			this.e = e1;
			this.f = f1;
		}
		
		public boolean isSolvable() {
			if (a * d - b * c == 0)
				return false;
			else
				return true;
		}
		public double getA() {
			return a;  
		  }
		  
		  public void setA(double a) {
		    this.a = a;
		  }
		   
		  public double getB() {
			return b;  
		  }
		  
		  public void setB(double b) {
		    this.b = b;
		  }
		  
		  public double getC() {
			return c;  
		  }
		  
		  public void setC(double c) {
		    this.c = c;
		  }
		  
		  public double getD() {
			return d;  
		  }
		  
		  public void setD(double d) {
		    this.d = d;
		  }
		  
		  public double getE() {
			return e;  
		  }
		  
		  public void setE(double e) {
		    this.e = e;
		  }
		  
		  public double getF() {
			return f;  
		  }
		  
		  public void setF(double f) {
		    this.f = f;
		  }
		  
		  // Get X
		  public double getX() {
			  double resultX = (e * d - b * f) / (a * d - b * c);
			  return resultX;
		  }
		  
		  // Get Y
		  public double getY() {
			  double resultY = (a * f - e * c) / (a * d - b * c);
			  return resultY;
		  }
		
		}
	
