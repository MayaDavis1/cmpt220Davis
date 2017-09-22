//5.13
public class FindLargestN {

	public static void main(String[] args) {
		
		//Start n at 0
		int n = 0; 
		
		while (Math.pow(n + 1,  3) < 12000) {
			n++;
		}
		
		//Output
		System.out.println("Largest integer n such that n^3 is less than 12,000: " + n);

	}

}
