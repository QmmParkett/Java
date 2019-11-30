package searchAlgorithms;

import java.util.Collections;

public class BinarySearch extends SearchBase {
	public static int[] definedArray = { 1, 2, 3, 5, 5, 5, 7, 8, 12 };

	public static void main(String[] args) {
		/*
		 * array = fillAray(10); Arrays.sort(array); printArray(array);
		 * binarySearch(array, rand.nextInt(20));
		 */
		printArray(definedArray);
		binarySearch(definedArray, 5);
		Collections.sort(indecesOfTargetsFound);
		evaluateResults(indecesOfTargetsFound, 5);
	}

	public static void binarySearch(int[] array, int target) {
		System.out.println("Target is: " + target);
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (int) (low + high) / 2;
			if (target == array[mid]) {
				indecesOfTargetsFound.add(mid);
				int onLeft = mid;
				int onRight = mid;
				while (target == array[--onLeft]) {
					indecesOfTargetsFound.add(onLeft);
					onLeft--;
				}
				while (target == array[++onRight]) {
					indecesOfTargetsFound.add(onRight);
					onRight++;
				}
				return;
			} else if (target <= array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	}

}
