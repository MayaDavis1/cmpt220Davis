//11.5
import java.util.ArrayList;
public class TestCourse {

	public static void main(String[] args) {
	    	  
	     Course course = new Course("Intro to Software Development");
	    	  
	    	  
	    	  // Add  13 students 	
	    	  for (int i = 0; i < 13; i++) {
	    		  course.addStudent("Student " + (i+1));
	    	  }
	    	  
	    	  // Display course name and current number of students
	    	  System.out.println("Course name: " + course.getCourseName() + "\n");
	    	  System.out.println("Number of students: " + course.getNumberOfStudents() + "\n");
	    	  

	 }
}
