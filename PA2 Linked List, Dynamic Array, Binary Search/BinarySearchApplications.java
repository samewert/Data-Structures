package PA2;

public class BinarySearchApplications {

	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int left = 0;
		int right = arrayLength - 1;
		int minIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key) {
				minIndex = mid;
				right = mid - 1;
			} else {
				if(key < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return minIndex;
	}

	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int left = 0;
		int right = arrayLength - 1;
		int maxIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key) {
				maxIndex = mid;
				left = mid + 1;
			} else {
				if(key < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return maxIndex;
	}

	public static int countNumberOfKeys(int array[], int arrayLength, int key) { // complete this method
		int maxIndex = maxIndexBinarySearch(array, arrayLength, key);
		int minIndex = minIndexBinarySearch(array, arrayLength, key);
		if(maxIndex == -1) {
			return 0;
		}
		return  maxIndex - minIndex + 1;
	}

	public static int predecessor(int array[], int arrayLen, int key) { // complete this method
		int left = 0;
		int right = arrayLen - 1;
		int predIndex = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array[mid] == key) {
				return mid;
			} else {
				if(key < array[mid]) {
					right = mid - 1;
				} else {
					predIndex = mid;
					left = mid + 1;
				}
			}
		}
		return predIndex;
	}
}
