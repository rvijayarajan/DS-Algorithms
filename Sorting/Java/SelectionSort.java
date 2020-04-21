import java.io.*;

public class SelectionSort {
	// index		- This variable keeps track of the index of the lowest number in the array.
	// No More Optimization
	public static void main(String args[]) throws IOException {
		int arr[] = {5,8,3,0,4};
		int index = -1;
		for(int i=0; i<arr.length-1; i++) {
			index = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[index]) {
					index = j;
				}
			}
			if(index != i) {
				arr[i] = arr[i] + arr[index];
				arr[index] = arr[i] - arr[index];
				arr[i] = arr[i] - arr[index];
			}
		}

		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}