import java.math.*;
import java.util.ArrayList;

//13.3
public class SortArrayList {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		// Add to array
		list.add(29);
		list.add(new BigInteger("1234567890123456789"));
		list.add(new BigDecimal("3.1234567890123456789"));
		list.add(15.27);
		list.add(2);
		
		System.out.print("Initial ArrayList: ");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+ " ");
		
		sort(list);
		
		System.out.print("\n" + "Sorted Array List: ");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " " );
	}

	private static void sort(ArrayList<Number> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find minimum
			Number currentMin = list.get(i);
			int currentIndex = i;
			
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.doubleValue() > list.get(j).doubleValue()) {
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
