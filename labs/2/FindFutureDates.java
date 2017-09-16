//3.5
import java.util.Scanner;

public class FindFutureDates {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		//Get todays day
		System.out.println("Enter today's day: ");
		int day = input.nextInt();
		
		//Get a number for a future day
		System.out.println("Enter the number of days elapsed since today: ");
		int futureDay = input.nextInt();
		
		//Equation for output
		int output = (day + futureDay) % 7;
		
		System.out.println("Today is the day ");
		switch (day) {
		case 0: System.out.println("Sunday"); break;
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); 
		}
		
		System.out.println(" and the future day is ");
		switch (output) {
		case 0: System.out.println("Sunday"); break;
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); 
		}

	
	}

}
