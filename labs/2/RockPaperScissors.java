//3.17
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Random integer
		int cmpt = (int)(Math.random() * 3);
		
		//Get number from user
		System.out.print("scissors (0), rock (1), paper (2): ");
		int user = input.nextInt();
		
		System.out.print("The computer is ");
		switch (cmpt) {
		case 0: System.out.print("scissors."); break;
		case 1: System.out.print("rock."); break;
		case 2: System.out.print("paper."); 
		
		}
		
		System.out.print(" You are "); 
		switch (user) {
		case 0: System.out.print("scissors."); break;
		case 1: System.out.print("rock."); break;
		case 2: System.out.print("paper.");
		}

		//Output
		if (cmpt == user)
			System.out.println(" It is a draw. ");
		else {
			boolean win = (user == 0 && cmpt ==2) ||
					      (user == 1 && cmpt == 0) ||
					      (user == 2 && cmpt == 1);
			if (win)
				System.out.println(" You won.");
			else
				System.out.println(" You lose");
		}
		
	}

}
