import java.io.*;

public class BubbleSort {
	// lastUnSorted - This variable limits the iteration since after every iteration one element to the end is at the right position.
	// swapped		- This variable makes sure that if no single element is sorted in a pass then the array is already sorted.
	public static void main(String args[]) throws IOException {
		int arr[] = {5,8,3,0,4};
		int lastUnSorted = arr.length-1;
		boolean swapped = true;
		for(int i=0; i<arr.length && swapped; i++) {
			swapped = false;
			for(int j=0; j<lastUnSorted; j++) {
				if(arr[j] > arr[j+1]) {
					arr[j] = arr[j] + arr[j+1];
					arr[j+1] = arr[j] - arr[j+1];
					arr[j] = arr[j] - arr[j+1];
					swapped = true;
				}
			}
			lastUnSorted--;
		}

		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}