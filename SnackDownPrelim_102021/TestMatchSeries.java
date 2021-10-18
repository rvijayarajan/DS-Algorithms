import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.regex.*;
import java.util.Scanner; 

public class TestMatchSeries {
	public static void main (String[] args) throws java.lang.Exception
	{
	    java.io.BufferedReader scanner = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
	    String v = scanner.readLine();
	    int testCases = v!=null ? Integer.parseInt(v) : 0;
	    for(int l =0; l<testCases; l++) {
	        String s = scanner.readLine();
	        String recepieString = s.replace(" ", "");
            recepieString = recepieString.replace("0", "");
            int length = recepieString.length();
            recepieString = recepieString.replace("1", "");
            int engLength = recepieString.length();
            int indiaLength = length - engLength;
            if(indiaLength > engLength) {
                System.out.println("INDIA");
            } else if(indiaLength < engLength) {
                System.out.println("ENGLAND");
            } else {
                System.out.println("DRAW");
            }
	    }

	}
}