import java.io.*;
import java.util.*;

public class MinimumSwap {
	public static void main(String[] args) throws IOException {
		
		// This solution is for sorting an unordered consecutive numbered array starting from 1 to N.

		int a[] = new int[]{7,1,3,2,4,5,6};
		// int a[] = new int[]{4,3,1,2};
		// int a[] = new int[]{2,3,4,1,5};
		// int a[] = new int[]{1,3,5,2,4,6,7};
		// int a[] = new int[]{3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
		int n = a.length;
		int count = 0;
		System.out.println("Input Array");
		for (int i=0; i< n; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		for (int i=0; i< n/2 ; i++) {
			if(a[i] != i+1) {
				int j = MinimumSwap.searchIndex(a,i,n-1-i,i+1);
				MinimumSwap.swapElements(a,i,j);
				count ++;	
			}
			if(a[n-1-i] != n-i) {
				int j = MinimumSwap.searchIndex(a,i+1,n-2-i,n-i);
				MinimumSwap.swapElements(a,n-1-i,j);
				count++;
			}
		}
		System.out.println("Count "+ count);
		System.out.println("Output Array");
		for (int i=0; i< n; i++) {
			System.out.print(a[i]+ " ");
		}
	}

	private static void swapElements(int a[], int index1, int index2) {
		a[index1] = a[index1] + a[index2];
		a[index2] = a[index1] - a[index2];
		a[index1] = a[index1] - a[index2];
	}

	private static int searchIndex(int a[], int fromIndex, int toIndex, int element) {
		for(int i=fromIndex; i<=toIndex; i++) {
			if(a[i] == element) {
				return i;
			}
		}
		return -1;
	}
}