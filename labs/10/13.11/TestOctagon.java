
public class TestOctagon {

	public static void main(String[] args) {
		Octagon oct1 = new Octagon(5);
		Octagon oct2 = (Octagon)oct1.clone();
		
		System.out.println("Octagon 1 has area " + oct1.getArea() + 
				" and perimeter " + oct1.getPerimeter());
		System.out.println("Does Octagon 1 equal cloned Octagon 2? " +  
				oct1.equals(oct2));
		System.out.println("Compare Octagon 1 and cloned Octagon 2: " +
				oct1.compareTo(oct2));

	}

}
