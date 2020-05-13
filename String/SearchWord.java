import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SearchWord {

    static String isWordPresent(String s) {
        Pattern wordPattern = Pattern.compile(".*?[h].*?[a].*?[c].*?[k].*?[e].*?[r].*?[r].*?[a].*?[n].*?[k].*+");
        Matcher m = wordPattern.matcher(s);
        if(m.find()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        String s = "hhaacckkekraraannk";
        System.out.println(isWordPresent(s));
    }
}
