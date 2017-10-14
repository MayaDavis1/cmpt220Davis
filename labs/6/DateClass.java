//9.3

import java.util.Date;

public class DateClass {
  public static void main(String[] args) {

  // Construct class 
    Date date = new Date(); 
  
    // Output
	System.out.println("Elapse Time   " + "Date and Time");
	
	// Use while loop to print rows
	long elapseTime = 100000;  // initialize
	int count = 1;
	while (count <= 8) {
	  date.setTime(elapseTime); 
	  System.out.println(elapseTime + "  " + date.toString()); 
	  elapseTime = elapseTime * 10;  // increment
	  count++;
	}				     
  }
}

