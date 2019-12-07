package searchAlgorithms;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class SearchBase {
	protected static int[] array;
	protected static SecureRandom rand = new SecureRandom();
	protected static List<Integer> indecesOfTargetsFound = new ArrayList<Integer>();

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}

	public static int[] fillAray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20);
		}
		return array;
	}

	public static void evaluateResults(List<Integer> indeces, int target) {
		if (!indeces.isEmpty()) {
			if (indeces.size() == 1) {
				System.out.print("The target " + target + " was found at index ");
			} else {
				System.out.print("The target " + target + " was found at indeces ");
			}
			indecesOfTargetsFound.forEach(value -> System.out.print(value + " "));
			System.out.println();
			indecesOfTargetsFound.clear();
		} else {
			System.out.println("The target " + target + " was not found!");
		}
	}
}
