import java.io.*;
import java.util.*;

public class ArrayRotate {
	public static void main(String[] args) throws IOException {
		
		int a[] = new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
		int totalElements = a.length;
		int rotateCount = 13;
		rotateCount = rotateCount % totalElements;
		System.out.println("Input Array");
		for (int i=0; i< totalElements; i++) {
			System.out.println(a[i]);
		}
		if(rotateCount > 0 && rotateCount < totalElements) {
			// Allowing only arrays
			// 1. With odd number of elements in its array
			// 2. With even number of elements in its array but the rotate count is a odd number and not half as that of total number of elements.
			if(totalElements%2==0) {
				int n = totalElements;
				for(int nextIndex = 0, i=1, baseIndex=0; i<=n; i++) {
					nextIndex = nextIndex - rotateCount;
					nextIndex = nextIndex < 0 ? nextIndex+totalElements : nextIndex;
					if(nextIndex != baseIndex) {
						a[baseIndex] = a[baseIndex] + a[nextIndex];
						a[nextIndex] = a[baseIndex] - a[nextIndex];
						a[baseIndex] = a[baseIndex] - a[nextIndex];
					}
					else {
						if(baseIndex==0) {
							if((totalElements/2 == rotateCount) || (rotateCount%2==0)) {
								n = i * (totalElements / (i));	
							}
						}
						nextIndex = ++baseIndex;
					}
				}
			} else {
				for(int nextIndex = 0, swapIndex = 0, i=1; i<totalElements ; i+=2) {
					nextIndex = nextIndex - rotateCount;
					swapIndex = nextIndex < 0 ? nextIndex+totalElements	: nextIndex;
					nextIndex = swapIndex - rotateCount;
					nextIndex = nextIndex < 0 ? nextIndex+totalElements : nextIndex;
					a[0] 			= a[0]	+	a[swapIndex] + a[nextIndex];
					a[swapIndex] 	= a[0]	- 	(a[swapIndex] + a[nextIndex]);
					a[nextIndex]	= a[0]	- 	(a[swapIndex] + a[nextIndex]);
					a[0]			= a[0]	- 	(a[swapIndex] + a[nextIndex]);
				}
			}
		}
		System.out.println("Output Array");
		for (int i=0; i< totalElements; i++) {
			System.out.println(a[i]);
		}
	}
}