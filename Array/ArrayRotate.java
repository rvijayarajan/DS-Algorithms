import java.io.*;
import java.util.*;

public class ArrayRotate {
	public static void main(String[] args) throws IOException {
		
		int a[] = new int[]{1,2,3,4,5};
		int b[] = new int[a.length];
		int n = a.length;
		int totalElements = n;
		int rotateCount = 5;
		System.out.println("Input Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
		int swapIndex = 0;
		int swapIndex2 = 0;
		int i = 0;
		for(i=0; i<totalElements-1 && rotateCount < totalElements && rotateCount > 0; i=i+2) {
			swapIndex = ArrayRotate.getSwapIndex(i,rotateCount,totalElements);
			swapIndex2 = ArrayRotate.getSwapIndex(i+1,rotateCount,totalElements);
			b[i] = a[swapIndex];
			b[i+1] = a[swapIndex2];
		}
		if(n%2 != 0) {
			swapIndex = ArrayRotate.getSwapIndex(i,rotateCount,totalElements);
			b[i] = a[swapIndex];
		}
		System.out.println("Output Array");
		if(rotateCount < totalElements) {
			for (int l=0; l< n; l++) {
				System.out.println(b[l]);
			}	
		} else {
			for (int l=0; l< n; l++) {
				System.out.println(a[l]);
			}	
		}
	}

	private static int getSwapIndex(int index, int rotateCount, int totalElements) {
		int swapIndex = -1;
		// To find where the element actually located in the initial array
		swapIndex = index + rotateCount < totalElements ? (index + rotateCount) : ((index + rotateCount) % totalElements);
		return swapIndex;
	}
}