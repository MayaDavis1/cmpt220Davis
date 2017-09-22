//4.21
import java.util.Scanner;
public class SSN {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Get number from user
		System.out.println("Enter a SSN: ");
		String ssn = input.nextLine();
		
		//Check if there are enough digits
		boolean isValid =
				(ssn.length() == 11) &&
				(Character.isDigit(ssn.charAt(0))) && 
				(Character.isDigit(ssn.charAt(1))) &&
				(Character.isDigit(ssn.charAt(2))) &&
				(ssn.charAt(3) == '-') &&
				(Character.isDigit(ssn.charAt(4))) &&
				(Character.isDigit(ssn.charAt(5))) &&
				(ssn.charAt(6) == '-') && // JA: Changed _ with -
				(Character.isDigit(ssn.charAt(7))) &&
				(Character.isDigit(ssn.charAt(8))) &&
				(Character.isDigit(ssn.charAt(9))) &&
				(Character.isDigit(ssn.charAt(10)));
				
				//Output
				System.out.println(ssn + " is " + ((isValid) ? "a valid " : "an invalid "
					) + "social security number");
				
	}

}
