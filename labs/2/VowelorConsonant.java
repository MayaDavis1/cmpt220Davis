//4.13
import java.util.Scanner; 

public class VowelorConsonant {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Get letter from user
		System.out.print("Enter a letter: ");
		String s = input.nextLine();
		char ch = s.charAt(0);
		
		if (Character.isLetter(ch)) {
			switch(Character.toUpperCase(ch)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U': System.out.println(ch + " is a vowel"); break;
			default: System.out.println(ch + " is a consonant");
			}
		}
		else
			System.out.println(ch + " is an invalid input");
	}

}
