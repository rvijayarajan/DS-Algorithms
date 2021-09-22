import java.io.*;

public class CountSort {
	public static void main(String args[]) throws IOException {
		int[] data = new int[]{0, 5, 2, 3, 1, 4, 6};
		for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        countSort(data, 6);
        System.out.println();
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
	}

	private static void countSort(int[] data, int max) {
		int[] count = new int[max+1];
		int[] temp = new int[data.length];
		for (int i=0; i<data.length; i++) {
			++count[data[i]];
		}
		for (int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		for (int i = data.length - 1; i >= 0; i--) {
			temp[--count[data[i]]] = data[i];
		}
		for (int i=0; i<data.length; i++) {
			data[i] = temp[i];
		}
	}
}