package PA4;

public class Recursion {

	public static int sumEvenDigits(int n) { // complete this function
		if(n == 0) {
			return 0;
		}
		if((n % 10) % 2 == 0) {
			return (n % 10) + sumEvenDigits(n/10);
		} 
		return sumEvenDigits(n/10);
	}

	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) { // complete this function
		if(str.length() == n && numZeroes < numOnes) {
			System.out.println(str);
			return;
		} else if(str.length() < n) {
			binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
			binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
		}
	}
}