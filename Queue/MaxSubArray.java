public class MaxSubArray {

	private static void printMax(int[] input, int group) {
		int max = 0;
		for (int i=0; i<group; i++) {
			max = max > input[i] ? max : input[i];
		}
		System.out.println(max);
		for(int i=group; i< input.length; i++) {
			max = max > input[i] ? max : input[i];
			System.out.println(max);
		}
	}

	public static void main(String args[]) throws Exception {
		int[] input = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 2;
		printMax(input,k);
	}
}
