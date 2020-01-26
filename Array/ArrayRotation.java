import java.io.*;
import java.util.*;

public class ArrayRotation {
	public static void main(String[] args) throws IOException {
		
		int a[] = new int[]{1,2,3,4,5};
		int n = a.length;
		System.out.println("Input Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
		int rotateCount = 4;
		int totalElements = a.length;
		int swapIndex = 0;
		int swapIndex2 = 0;
		for(int i=0; i<totalElements-1 && rotateCount < totalElements && rotateCount > 0; i=i+2) {
			swapIndex = ArrayRotation.getSwapIndex(i,i,rotateCount,totalElements);
			swapIndex2 = ArrayRotation.getSwapIndex(i+1,i+1,rotateCount,totalElements);	
			if(i != swapIndex) {
				a[i] = a[i] + a[swapIndex];
				a[swapIndex] = a[i] - a[swapIndex];
				a[i] = a[i] - a[swapIndex];	
			}
			if(i+1 != swapIndex2 && i+1 != totalElements-1) {
				a[i+1] = a[i+1] + a[swapIndex2];
				a[swapIndex2] = a[i+1] - a[swapIndex2];
				a[i+1] = a[i+1] - a[swapIndex2];	
			}
		}
		System.out.println("Output Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
	}

	private static int getSwapIndex(int index, int actualIndex, int rotateCount, int totalElements) {
		int swapIndex = -1;
		// To find where the element actually located in the initial array
		swapIndex = index + rotateCount < totalElements ? (index + rotateCount) : ((index + rotateCount) % totalElements);

		// To find where the element is located in the current array
		swapIndex = swapIndex > index ? swapIndex : getSwapIndex(swapIndex, actualIndex, rotateCount, totalElements);	
		swapIndex = actualIndex > swapIndex ? getSwapIndex(swapIndex, actualIndex, rotateCount, totalElements) : swapIndex;
		return swapIndex;
	}
}