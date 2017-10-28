// 10.5
import java.util.Scanner; 

public class DisplayPrimeFactors {

	public static void main(String[] args) {
		// Get input from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		int number = input.nextInt();
		
		//Run StackOfIntegers
		StackOfIntegers stack = new StackOfIntegers(16);
		
		//Find factors
		int factor = 2;
		while (factor <= number) {
			if (number % factor == 0) {
				stack.push(factor);;
				number = number / factor;
			} else {
				factor++;
			}
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}

	}

}
