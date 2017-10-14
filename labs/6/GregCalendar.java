//9.5
import java.util.*;

public class GregCalendar {
	public static void main(String[] args) {
		
		//Today's Date
		Calendar calendar = new GregorianCalendar();
		Date currentTime = new Date();
		System.out.println("Today's date is: " + calendar.get(Calendar.YEAR) + ", " 
		+ calendar.get(Calendar.MONTH) + ", " + calendar.get(Calendar.DAY_OF_MONTH));
	
	
	// 1234567898765L seconds since January 1, 1970.
		calendar.setTimeInMillis(1234567898765L);
		System.out.println("1234567898765L seconds since January 1, 1970 is: " 
		+ calendar.get(Calendar.YEAR) + ", " 
				+ calendar.get(Calendar.MONTH) + ", " + calendar.get(Calendar.DAY_OF_MONTH));
	}		
}



