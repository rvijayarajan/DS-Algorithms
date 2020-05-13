import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReplaceRecurrentChar {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        Pattern p = Pattern.compile("([a-z])(\\1){1}");
        String s1 = null;
        if(s!=null) {
            while(!s.equals(s1)) {
                s1 = s;
                Matcher m = p.matcher(s1);
                if (m.find()) {
                     s = m.replaceAll("");
                }
            }
        }
        return s!=null&&s.length()>0 ? s : "Empty String";
    }

    public static void main(String[] args) throws IOException {
        String s = "aaabccddd";
        String result = superReducedString(s);
        System.out.println(result);
    }
}
