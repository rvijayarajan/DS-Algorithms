import java.io.*;

public class RadixSort {
	public static void main(String args[]) throws IOException {
		int[] data = new int[]{38, 27, 43, 3, 9, 821, 10};
		for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        radixSort(data, 821);
        System.out.println();
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
	}

	private static void radixSort(int[] data, int max) {
		for (int pass = 1; (max/pass) > 0; pass = pass * 10) {
			countSort(data, pass);
		}
	}

	private static void countSort(int[] data, int pass) {
		int[] count = new int[10];
		int[] temp = new int[data.length];
		for (int i=0; i<data.length; i++) {
			++count[(data[i]/pass)%10];
		}
		for (int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		for (int i = data.length - 1; i >= 0; i--) {
			temp[--count[(data[i]/pass)%10]] = data[i];
		}
		for (int i=0; i<data.length; i++) {
			data[i] = temp[i];
		}
	}
}