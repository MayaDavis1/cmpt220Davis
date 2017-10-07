//7.19
import java.util.Scanner;

public class Sorted {

    public static void main(String[] args) {

    	// Get input from user
    	Scanner input = new Scanner(System.in);

    	System.out.println("Enter the size of the list: ");
	int size = input.nextInt();
	System.out.println("Enter the contents of the list: ");
	int[] list = new int[size];
    
	// Store into the array
	for (int i = 0; i < list.length; i++)
	list[i] = input.nextInt();

    
	// Print list size
	System.out.print("The list has " + size + " integers: ");
	
	// Print list elements
	for (int i = 0; i < list.length; i++) {
	  System.out.print(list[i] + " "); 
	 
	}
	
	// Determine if the list is sorted
	System.out.println("The list is " + (isSorted(list) ? " already " : "not ") + "sorted.");

	}
	private static boolean isSorted(int[] list) {
	  for (int i = 0; i < list.length - 1; i++) {
	    if (list[i] > list[i + 1])
	      return false;
	    }
	   return true;
	}

}