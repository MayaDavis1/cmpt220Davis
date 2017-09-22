//5.1

import java.util.Scanner;

public class PositivesandNegatives {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Get input from user
		System.out.println("Enter an integer, the input ends if it is 0: ");
		
		
		// Initialize input number and variables before entering the loop. 
				int number = 1;
				int positiveCount = 0;
				int negativeCount = 0;
				double finalSum = 0;
		   
	
				// Keep reading the input until number is 0  
				while (number != 0) {              
				    number = input.nextInt();
				    finalSum += number;

				    if (number > 0) 
				        positiveCount++;
				    else if (number < 0)
				        negativeCount++;	     
				}

				System.out.println("The number of positives is: "+ positiveCount);

				System.out.println("The number of negatives is: "+ negativeCount);

				System.out.println("The total is: "+ finalSum);

				if (positiveCount + negativeCount > 0)  
				    System.out.println("The average is: "+ finalSum/(positiveCount+negativeCount));
				else // Avoid divide by zero    
				    System.out.println("The average is: 0");
			}
		}