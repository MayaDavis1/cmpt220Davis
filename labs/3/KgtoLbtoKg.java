//5.5
public class KgtoLbtoKg {
	public static void main(String[] args) {
		//Constant value for kilograms to lbs
		final double POUNDS_PER_KILOGRAM = 2.2; 
		
		//Table
		System.out.println( "Kilograms     Pounds   |   Pounds     Kilograms");
		for (int k = 1, l = 20; k <= 199 && l <= 515; k += 2, l += 5) {
			System.out.printf( "%-12d%7.1f" , k, (k * POUNDS_PER_KILOGRAM));
			System.out.print("    |   ");
			System.out.printf("%-9d%12.2f\n", l, (l / POUNDS_PER_KILOGRAM));
		}
	}
}
