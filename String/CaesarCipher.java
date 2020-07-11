import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {

    static String encrypt(String s, int k) {
        k = k %26;
        String s1 = "";
        for(int i=0; i<s.length(); i++ ) {
            int ascii = (int)s.charAt(i);
            if(ascii>=65 && ascii<=90) {
                if((ascii+k) > 90) {
                    ascii = 64+((ascii+k)-90);
                    s1 += Character.toString((char)(ascii));
                } else {
                    s1 += Character.toString((char)(ascii+k));    
                }
            } else if (ascii >=97 && ascii<=122) {
                if((ascii+k) > 122) {
                    ascii = 96+((ascii+k)-122);
                    s1 += Character.toString((char)(ascii));
                } else {
                    s1 += Character.toString((char)(ascii+k));    
                }
            }else {
                s1 += (s.charAt(i));    
            }
        }
        return s1;
    }

    public static void main(String[] args) throws IOException {
        String s = "www.abc.xy";
        System.out.println(encrypt(s,87));
    }
}
