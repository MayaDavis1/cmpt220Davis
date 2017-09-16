//4.9
import java.util.Scanner;

public class Unicode {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		//Get character from user
		System.out.println("Enter a character: ");
		String s = input.nextLine();
		char ch = s.charAt(0);
		
		//Output
		System.out.println((int)ch); 
		
		

	}

}
