//10.9 Test
public class CourseTest {

	public static void main(String[] args) {
  	  
  	  Course course = new Course("Software Development 1");
  	  
  	  
  	  // Add  13 students 	
  	  for (int i = 0; i < 3	; i++) {
  		  course.addStudent("Student " + (i + 1));
  	  }
  	  
  	  // Display course name and current number of students
  	  System.out.println("Course name: " + course.getCourseName() + "\n");
  	  System.out.println("Number of students: " + course.getNumberOfStudents() + "\n");
  	  
  	  // Drop 1 student
  	  System.out.println("Drop 1 student" + "\n");
  	  course.dropStudent("Student " + (1) );
  	  
  	  // Display course name and students
  	  System.out.println("Course name: " + course.getCourseName() + "\n");
  	  System.out.println("Number of students: " + course.getNumberOfStudents() + "\n");
  	  String[] students = course.getStudents();
  	  for (int i = 0; i < students.length; i++) {
  		  System.out.printf("Student name: " + students[i] + "\n"); 
  	  }
 }
}

