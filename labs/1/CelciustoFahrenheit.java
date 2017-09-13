//2.1
import java.util.Scanner;

public class CelciustoFahrenheit {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Get temperature from user
		System.out.println(" Enter a degree in Celsius: ");
		double celsius = input.nextDouble();
		
		//Convert to Fahrenheit
		double fahrenheit = ((9.0 / 5) * celsius + 32);
		System.out.println( celsius + " Celsius " + "is " + fahrenheit + 
				" in Fahrenheit ");
	}

}
