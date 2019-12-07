package searchAlgorithms;

public class LinearSearch extends SearchBase {

	public static void main(String[] args) {
		array = fillAray(10);
		printArray(array);
		linearSearch(array, rand.nextInt(20));
		reverseLinearSeach(array, rand.nextInt(20));
	}

	public static void linearSearch(int[] array, int target) {
		System.out.println("Target is: " + target);
		for (int i = 0; i <= array.length - 1; i++) {
			if (array[i] == target) {
				indecesOfTargetsFound.add(i);
			}
		}
		evaluateResults(indecesOfTargetsFound, target);
	}

	public static void reverseLinearSeach(int[] array, int target) {
		System.out.println("Target is: " + target);
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == target) {
				indecesOfTargetsFound.add(i);
			}
		}
		evaluateResults(indecesOfTargetsFound, target);
	}

}
