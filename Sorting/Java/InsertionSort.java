import java.io.*;

public class InsertionSort {
	
  public static void main(String args[]) throws IOException {
		int arr[] = {1, 4, 3, 5, 6, 2};

		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>=1 && arr[j] < arr[j-1]; j--) {
				arr[j-1] = arr[j-1] + arr[j];
				arr[j] = arr[j-1] - arr[j];
				arr[j-1] = arr[j-1] - arr[j];
			}
		}

		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}