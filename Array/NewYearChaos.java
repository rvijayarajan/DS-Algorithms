import java.io.*;
import java.util.*;

public class NewYearChaos {
	public static void main(String[] args) throws IOException {
		File file1 = new File("D:\\Vijay\\Learnings\\DataStructure\\DS-Algorithms\\Array\\test");
		BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
		  String st1, st2 = ""; 
		  while ((st1 = br1.readLine()) != null) {
		  	if(st1 != null) {
		  		st2 += st1;
		  	}
		  }
		 String b[] = st2.split(" ");
		 // int a[] = new int[b.length];
		 // for(int i=0;i<a.length;i++) {
		 // 	a[i] = Integer.parseInt(b[i]);
		 // }
		int a[] = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
		int totalElements = a.length;
		int bribes = 0;
		System.out.println("Input Array");
		for (int i=0; i< totalElements; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		int n = a.length;
	    int cnt = 0;
	    for(int i = n - 1; i >= 0; i--)
	    {
	        if(a[i] != (i + 1))
	        {
	            if(((i - 1) >= 0) && a[i - 1] == (i + 1))
	            {
	                cnt++;
	                a[i] = a[i] + a[i-1];
					a[i-1] = a[i] - a[i-1];
					a[i] = a[i] - a[i-1];
	            }
	            else if(((i - 2) >= 0) && a[i - 2] == (i + 1))
	            {
	                cnt += 2;
	                a[i - 2] = a[i - 1];
	                a[i - 1] = a[i];
	                a[i] = i + 1;
	            }
	            else
	            {
	                System.out.println("Too chaotic");
	            }
	        }      
	    }
	    System.out.println(cnt);
	}
}