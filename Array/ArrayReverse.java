import java.io.*;
import java.util.*;

public class ArrayReverse {
	public static void main(String[] args) throws IOException {
		
		int a[] = new int[]{4,2,2,1};
		int n = a.length;
		System.out.println("Input Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
		for (int i=0; i< n/2 && a[i] != a[n-i-1]; i++) {
			a[i] = a[i] + a[n-i-1];
			a[n-i-1] = a[i] - a[n-i-1];
			a[i] = a[i] - a[n-i-1];
		}
		System.out.println("Output Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
	}
}