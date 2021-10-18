import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.regex.*;
import java.util.Scanner; 

public class LuckyNumber {
	public static void main (String[] args) throws java.lang.Exception
	{
	    java.io.BufferedReader scanner = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
        String v = scanner.readLine();
	    int testCases = v!=null ? Integer.parseInt(v) : 0;
	    for(int l =0; l<testCases; l++) {
	        String s = scanner.readLine();
	        String recepieString = s.replace(" ", "");
            int data = Integer.parseInt(recepieString);
            boolean passed = false;
	        for (int pass = 1; (999/pass) > 0; pass = pass * 10) {
                if((data/pass)%10 == 7) {
                    passed = true;
                    System.out.println("YES");
                    break;
                }
            }
            if(!passed) {
                System.out.println("NO");
            }
	    }

	}
}