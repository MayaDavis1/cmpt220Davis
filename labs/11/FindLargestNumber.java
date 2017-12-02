import java.util.Scanner;

public class FindLargestNumber {

	public static void main(String[] args) {
		int n = 8;
		int max;
		int arr[] = new int[n];
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 8 numbers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		//Find largest number 
		max = MaxNumber(arr, arr.length);
		System.out.println("The largest number in the array is: " + max);

	}

	private static int MaxNumber(int[] arr, int length) {
		if (length == 1)
			return arr[0];
		else
			return max(MaxNumber(arr, length - 1), arr[length - 1]);
	}

	private static int max(int n1, int n2) {
		if (n1 > n2)
			return n1;
		else
			return n2;
	}

}
