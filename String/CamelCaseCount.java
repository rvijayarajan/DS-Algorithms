import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CamelCaseCount {

    static int countCamelCase(String s) {
        int count = 1;
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(s);
        while(m.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String s = "saveChangesInTheEditor";
        int result = countCamelCase(s);
        System.out.println(result);
    }
}
