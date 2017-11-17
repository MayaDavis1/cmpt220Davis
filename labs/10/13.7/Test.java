//13.7
public class Test {

	public static void main(String[] args) {
		GeometricObject[] obj = new GeometricObject[5];
		obj[0] = new Circle(9);
		obj[1] = new Square(7);
		obj[2] = new Rectangle(5, 8);
		obj[3] = new Square(13);
		obj[4] = new Square(45);
		
		for (int i = 0; i < obj.length; i++) {
			// Area
			System.out.println("Geometric object " + i + " area is: " + obj[i].getArea());
			
			// Color
			if (obj[i] instanceof Colorable) {
				System.out.println("How to color: " + ((Colorable)obj[i]).howToColor());
			} else {
				System.out.println("How to color: Not colorable.");
			}
		}
		
	}

}
