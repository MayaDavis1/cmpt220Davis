//10.3
public class MyInteger {
	private int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven() {
		return value % 2 == 0;
	}
	
	public boolean isOdd() {
		return value % 2 != 0;
	}
	
	public boolean isPrime() {
		for (int divisor = 2; divisor <= value / 2; divisor++) {
			if (value % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	public static boolean isOdd(int value) {
		return value % 2 != 0;
	}
	
	public static boolean isPrime(int value) {
		for (int divisor = 2; divisor <= value / 2; divisor++) {
			if (value % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEven(MyInteger myInteger) {
		return myInteger.isEven();
	}
	public static boolean isOdd(MyInteger myInteger) {
		return myInteger.isOdd();
	}
	public static boolean isPrime(MyInteger myInteger) {
		return myInteger.isPrime();
		}
	
	public boolean equals(int value) {
		return this.value == value;
	}
	
	public boolean equals(MyInteger myInteger) {
		return this.value == myInteger.value;
	}
	
	public static int parseInt(char[] value) {
		int number = Integer.parseInt(new String(value));
		return number;
	}
	
	public static int parseInt(String value) {
		return MyInteger.parseInt(value.toCharArray());
	}
}


	
