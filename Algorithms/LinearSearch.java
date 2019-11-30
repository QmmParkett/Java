package searchAlgorithms;

public class LinearSearch extends SearchBase {

	public static void main(String[] args) {
		array = fillAray(10);
		printArray(array);
		linearSearch(array, rand.nextInt(20));
	}

	public static void linearSearch(int[] array, int target) {
		System.out.println("Target is: " + target);
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				indecesOfTargetsFound.add(i);
			}
		}
		evaluateResults(indecesOfTargetsFound, target);
	}

}
