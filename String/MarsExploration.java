import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {

    static int searchCharctersMissed(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i+=3 ) {
            if(s.charAt(i) != 'S') {
                count++;
            }
            if(s.charAt(i+1)!='O') {
                count++;
            }
            if(s.charAt(i+2)!='S') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String s = "SPLSOSSOSSOSJIOFOSSOS";
        System.out.println(searchCharctersMissed(s));
    }
}
