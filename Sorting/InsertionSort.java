import java.io.*;

public class InsertionSort {
	// swapped		- This variable tells when to break the inner loop if the remaining elements of that array are already sorted.
	// No More Optimization
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

		// int arr[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
		// int key = arr[arr.length-1];
  //       for(int j=arr.length-2; j>=0; j--) {
  //           if(arr[j] > key) {
  //               arr[j+1] = arr[j];
  //               if(j==0) {
  //               	arr[j] = key;
  //               }
  //           } else {
  //           	arr[j+1] = key;		
  //               break;
  //           }
  //           for(int i=0; i<arr.length; i++) {
  //               System.out.print(arr[i]+" ");
  //           }
  //           System.out.println();
  //       }
  //       for(int i=0; i<arr.length; i++) {
  //           System.out.print(arr[i]+" ");
  //       }
	}
}