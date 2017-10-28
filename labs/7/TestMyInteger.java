//10.3 Test
import java.util.Scanner;
public class TestMyInteger {	
	    public static void main(String[] args) {
	    	
	    	Scanner input = new Scanner(System.in);
	  	  
	  	  // Get input from user
	  	  System.out.print("Enter 3 integers: ");
	  	  int n1 = input.nextInt();
	  	  int n2 = input.nextInt();
	  	  int n3 = input.nextInt();
	  	  
	    	  MyInteger number1 = new MyInteger(n1);
	    	  MyInteger number2 = new MyInteger(n2);
	    	  MyInteger number3 = new MyInteger(n3);
	    	  
	    	  
	    	  // Display the number and whether it is even, odd, and prime
	    	  System.out.printf("Number 1 is " + number1.getValue() +    
	    	                    "  Even: " + number1.isEven() +
	    	                    "  Odd: " + number1.isOdd() + 
	    	                    "  Prime: " + number1.isPrime() +"\n");	
	    	  System.out.printf("Number 2 is " + number2.getValue() +    
	                        "  Even: " + number2.isEven() +
	                        "  Odd: " + number2.isOdd() + 
	                        "  Prime: " + number2.isPrime() +"\n");	
	    	  System.out.printf("Number 3 is " + number3.getValue() +    
	                        "  Even: " + number3.isEven() +
	                        "  Odd: " + number3.isOdd() + 
	                        "  Prime: " + number3.isPrime() +"\n");	
	   
	    	  System.out.printf("Number 1 = Nummber 2: " + number1.equals(number2) + "\n");
	    	  System.out.printf("Number 1 = Nummber 3: " + number1.equals(number3) + "\n");
	    	  System.out.printf("Number 2 = Nummber 3: " + number2.equals(number3) + "\n");
	    	  
	    	  // Convert an array of numeric characters to an int value
	    	  System.out.print("Parse int char value 12345 is: " + MyInteger.parseInt("12345") + "\n");
	    	  	  
	    	  // Convert a Sting of "123" to int
	    	  System.out.printf("Parse int string value 123 is: " + MyInteger.parseInt("123") + "\n");
	    	  

	    	  
	    }
	}