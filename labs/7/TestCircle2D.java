//10.11
public class TestCircle2D {
	    public static void main(String[] args) {		  
		  // Create circle c1 and display circle info
	    	  Circle2D c1 = new Circle2D(2, 2, 5.5);
		  System.out.println("c1 area = " + c1.getArea() + " perimeter = " + c1.getPerimeter());
		  
		  // Display results
		  System.out.println("Does c1 contain coordinate (3, 3)?  " + c1.contains(3, 3));
		    
		  System.out.println("Does c1 contain coordinate circle 2?  " + c1.contains(new Circle2D(4, 5, 10.5)));
		    
		  System.out.println("Does c1 overlap  circle 3?  " + c1.overlaps(new Circle2D(3, 5, 2.3)));	    
		    } 
		}


	class Circle2D {	    
		public double x;
		public double y;
		public double radius;

		// Default
		public Circle2D(Circle2D c) {
		  this(c.getX(), c.getY(), c.getRadius());	
		}
		
		public Circle2D(double x, double y, double radius) {
	      this.x = x;
	      this.y = y;
	      this.radius = radius; 
		}
		
		// A no-arg constructor that creates a default circle with (0,0) for (x,y) and 1 for radius
	    public Circle2D() {
	    	  this(0, 0, 1);
	    }
	    
		
		// Getters
		public double getX() {
		  return x;
		}

		public void setX(double x) {
		  this.x = x;
		}
		
		public double getY() {
		  return y;
		}
		
		public void setY(double y) {
		  this.y = y;
	    }
		
		public double getRadius() {
		  return radius;
		}

		public void setRadius(double radius) {
		  this.radius = radius;	
		}
		
		
		// Equations
		public double getArea() {
		  return radius * radius * Math.PI;
		}
		
		public double getPerimeter() {
		  return 2 * radius * Math.PI;

		}
		
		
	    // Returns true if the specified point (x, y) is inside this circle
		public boolean contains(double x, double Y) {
		  // Calculate the distance between the point and center of this circle	
		  double distance = Math.sqrt((this.x - x) * (this.x - x) + 
		          (this.y - y) * (this.y - y));
					        
		  if (distance <= radius) 
			return true;
		  else
		    return false;
		}

		
	    // Returns true if the specified circle is inside this circle 
		public boolean contains(Circle2D circle) {
	      // Calculate the distance between the 2 circle centers	
		  double distance = Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + 
		          (this.y - circle.getY()) * (this.y - circle.getY()));	
	      
	      if (distance <= Math.abs(this.radius - circle.radius)) {
	    	    return true;
	      } else {
	        return false;
	      }
		}

	    
		// Return true if the specified circle overlaps with this circle
		public boolean overlaps(Circle2D circle) {	
		  // Calculate the distance between the 2 circle centers
		  double distance = Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + 
			      (this.y - circle.getY()) * (this.y - circle.getY()));	
	      
	      if (distance <= this.radius + circle.radius) {
	    	    return true;
	      } else { 
	    	    return false;
	      }  
		}

	}	


