package PA1;

public class Sorting {

	public static void selectionSort(int[] array, int arrayLen) { // complete this method
		for(int i = 0; i < arrayLen - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < arrayLen; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int minValue = array[minIndex];
			array[minIndex] = array[i];
			array[i] = minValue;
		}
	}

	public static void insertionSort(int[] array, int arrayLen) { // complete this method
		for(int i = 1; i < arrayLen; i++) {
			int j = i;
			int temp = array[j];
			while(j > 0 && temp < array[j - 1]) {
				array[j] = array[--j];
				array[j] = temp;
			}
		}
	}
}
