//9.1
public class Rectangle {
  
  public static void main(String[] args) {
	  
    Rectangle rectangle1 = new Rectangle();
    System.out.println("Width: " + rectangle1.width + " Height: " + rectangle1.height +
    		" Perimeter: " + getPerimeter() + " Area: " + getArea());

	// Rectangle width 4 height 40
	Rectangle rectangle2 = new Rectangle(4,40);
	System.out.println("Width: " + rectangle2.width + " Height: " + rectangle2.height +
		" Perimeter: " + getPerimeter() + " Area: " + getArea());
	
	// Rectangle width 3.5 height 35.9
	Rectangle rectangle3 = new Rectangle(3.5,35.9);
	System.out.println("Width: " + rectangle3.width + " Height: " + rectangle3.height +
		" Perimeter: " + getPerimeter() + " Area: " + getArea());
  }

  private static double getArea() {
	return height * width;
  }

  private static double getPerimeter() {
    return (2 * height) + (2 * width);
  }

  static double height;
  static double width;

  Rectangle() {
    height = 1;
    width = 1;
  }

  // New rectangle
  Rectangle(double newWidth, double newHeight) {
	width = newWidth;
	height = newHeight;
  }
	  
}