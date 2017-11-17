
public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(6);
		Circle c2 = new Circle(6);
		Circle c3 = new Circle(10);
		
		System.out.println("Does c1 equal c2? " + c1.equals(c2));
		System.out.println("Does c2 equal c3? " + c2.equals(c3));
		System.out.println("Does c3 equal c1? " + c3.equals(c1));
		System.out.println("Compare c1 and c2. " + c1.compareTo(c2));
		System.out.println("Compare c2 and c3. " + c2.compareTo(c3));
		System.out.println("Compare c3 and c1. " + c3.compareTo(c1));
		

	}

}
