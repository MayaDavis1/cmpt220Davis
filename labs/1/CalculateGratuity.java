//2.5
import java.util.Scanner;

public class CalculateGratuity {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Get subtotal and gratuity rate from user 
		System.out.println("Enter the subtotal and a gratuity rate: ");
		double subtotal = input.nextDouble();
		double gratuity = input.nextDouble(); 
		
		//Calculate gratuity 
		double calculate = (subtotal * (gratuity / 100));
		
		//Calculate total
		double total = (calculate + subtotal); 
		
		//Output Result
		System.out.println(" The gratuity is " + calculate + " and the total is " + 
		 total );
		
		
		
	}

}
