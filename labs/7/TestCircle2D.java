//10.11 Test
public class TestCircle2D {

	public static void main(String[] args ) {
		public static void main(String[] args) {
		
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		
		System.out.println("c1 area = " + c1.getArea() + "perimeter = " + c1.getPerimeter());
		  
		System.out.println("Does c1 contain coordinate (3,3)? " + c1.contains(3, 3));
		    
		System.out.println("Does c1 contain coordinate circle 2? " + c1.contains(new Circle2D(4, 5, 10.5)));
		    
		System.out.println("Does c1 overlap  circle 3? " + c1.overlaps(new Circle2D(3, 5, 2.3)));
		   
} 
}
