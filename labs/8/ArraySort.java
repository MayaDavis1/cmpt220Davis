//11.11
import java.util.ArrayList;
import java.util.Scanner;
public class ArraySort {
	public static void main(String[] args) {
	// Get input from user
	Scanner input = new Scanner(System.in);
	System.out.println("Enter 5 numbers: ");
	ArrayList<Integer> list = new ArrayList<>();
	for (int i = 0; i < 5; i++) list.add(input.nextInt());
	sort(list);
	System.out.println(list);
	}
	
	public static void sort(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() -1; i++) {
			int currentMin = list.get(i);
			int currentIndex = i;
			
			for (int j = i + 1; j < list.size(); j++ ) {
				if (currentMin > list.get(j)) {
					currentMin = list.get(j); 
					currentIndex = j;
				}
			}
			
			if (currentIndex != i) {
				list.set(currentIndex,  list.get(i));
				list.set(i,  currentMin);
			}
		}
	}
}
