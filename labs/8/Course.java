//11.5
import java.util.ArrayList;

public class Course {
  private String courseName;
  private int numberOfStudents;
  private ArrayList<String> students = new ArrayList<>();
 
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
	  students.add(student);	
  }

  
  public void dropStudent(String student) {
	  students.remove(student);
  }
 

  public String[] getStudents() {
 	  return students.toArray(new String[students.size()]);
  }
 
  
 
  public int getNumberOfStudents() {
 	  return students.size();
  }

 
 // Remove all students from the course
  public void clear() {
 	  students.clear();
 	  numberOfStudents = 0;
  }
 
}
