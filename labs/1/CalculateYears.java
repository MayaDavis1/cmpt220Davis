//2.7

import java.util.Scanner;

public class CalculateYears {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Get minutes from user
		System.out.println(" Enter the number of minutes: ");
		int minutes = input.nextInt();
		
		//Calculate years
	    int years = minutes / (60 * 24 * 365);
	    
	    //Calculate remaining minutes
	    int remainingMinutes = minutes % (60 * 24 * 365);
	    
	    //Calculate days
	    int days = remainingMinutes / (60 * 24);
	    int remainderMinutes = remainingMinutes % (60 * 24);
	    
	    //Output
	    System.out.println(minutes + " minutes is apporximately " + years +
	    		" years and " + days + " days");
		
		
		
		

	}

}
