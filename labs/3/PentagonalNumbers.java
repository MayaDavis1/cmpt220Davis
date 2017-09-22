//6.1
public class PentagonalNumbers {

	public static void main(String[] args) {
		// Display first 100 pentagonals
		final int NUMBER_OF_PENTAGONALS = 100; 

		// Display 10 numbers per line
		final int NUMBER_PER_LINE = 10;
		
		System.out.println("The first 100 pentagonal numbers: ");
		for (int i = 1; i <= NUMBER_OF_PENTAGONALS; i++) {
			if(i % NUMBER_PER_LINE == 0)
				System.out.printf("%7d\n", getPentagonalNumber(i));
			else
				System.out.printf("%7d", getPentagonalNumber(i));
		}
		
		}
		
		public static int getPentagonalNumber(int n) {
			return (n * (3 * n - 1)) / 2; 
	}

}
