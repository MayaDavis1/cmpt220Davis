//10.11
import javafx.scene.shape.Circle;
public class Circle2D {
	public double x;
	public double y;
	public double radius;

	//Default
	public Circle2D(Circle c) {
	  this(c.getCenterX(), c.getCenterY(), c.getRadius());	
	}
	
	public Circle2D(double x, double y, double radius) {
      this.x = x;
      this.y = y;
      this.radius = radius; 
	}
	
	// A no-arg constructor that creates a default circle with (0,0) for (x,y) and 1 for radious
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

    // Returns true if the specified point is inside this circle
	public boolean contains(double x, double Y) {
	  double distance = getPoint().distance(x,y);
	  
	  if (distance <= radius) 
		return true;
	  else
	    return false;
	}

	// Returns true if the specified circle is inside this circle
	public boolean c1ContainsC2(Circle c1, Circle c2) {
	  Circle2D circle1 = new Circle2D(c1);
	  Circle2D circle2 = new Circle2D(c2);
	  if (circle1.contains(circle2)) 
	    return true;
	  else
	  return false; 
	}
	
    // Returns true if the specified circle is inside this circle 
	public boolean contains(Circle2D circle) {
      double distance = getPoint().distance(circle.x, circle.y);
      if (distance <= Math.abs(this.radius - circle.radius)) {
    	    return true;
      } else {
        return false;
      }
	}


	public boolean overlaps(Circle2D circle) {
      double distance = getPoint().distance(circle.x, circle.y);
      if (distance <= this.radius + circle.radius) 
    	    return true;
      else 
    	    return false;

	}

	
	private MyPoint getPoint() {
	  return new MyPoint(this.x, this.y);		
	}
	
	public String toString() {
	  return "Circle2D{" +
	         "x=" + x +
	         ", y=" + y +
	         ", radius=" + radius +
	         '}';
	
	}
	private class MyPoint {
		  private double x;
		  private double y;

		  public MyPoint() {
		  }

		  public MyPoint(double x, double y) {
		    this.x = x;
		    this.y = y;
		  }
	}
	
}