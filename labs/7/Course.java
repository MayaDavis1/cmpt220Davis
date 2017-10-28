//10.9
import java.util.Arrays;

public class Course {
    private String courseName;
    private String[] students = new String[4];  // Fixed number
    private int numberOfStudents;
    
    public Course(String courseName) {
    	  this.courseName = courseName;
    }
    
   
  	public void setCourseName(String courseName) {
  	  this.courseName = courseName;
  	}
   
  	
  	public String getCourseName() {
  	  return courseName;	
  	}
   
    public void addStudent(String student) {
    
    	  // Push a new student element onto the top of the stack 
    	  if (numberOfStudents >= students.length) {
      	  String[] temp = new String[students.length * 2];
    		  System.arraycopy(students,  0,  temp,  0,  students.length);
    		  students = temp;
    	  }
    	  students[numberOfStudents++] = student;	  
    }
    
    
    public String[] getStudents() {
      if (numberOfStudents <= students.length) {
    	      String[] temp = new String[numberOfStudents];
    	      System.arraycopy(students,  0,  temp,  0,  numberOfStudents);
    	      students = temp;
    	  }
      
      return students;
    }
    
    public int getNumberOfStudents() {
    	  return numberOfStudents;
    }
    
    public void dropStudent(String student) {
    	    for (int i = 0; i < students.length; i++) {
    	    	
    	    	    if (student.equals(students[i])) {
    	    	    	  students[i] = null;   // Clear array element to null
    	    	    	  numberOfStudents--;
    	    	    	  while (i < numberOfStudents) {
    	    	    		students[i] = students[i + 1];
    	    	    		i++;
    	    	    	  }
    	    	    	  break;
    	    	    }
    	    }
    	
    }
    
    //Remove all students from the course
    public void clear() {
    	  students = new String[20];
    	  numberOfStudents = 0;
    }
    
}