import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrongPassword {

    static int strongPassword(String s) {
        int count = 0;
        int length = s!=null ? s.length() : 0;
        Pattern numberPattern = Pattern.compile("(?=.*[0-9])");
        Pattern upperCasePattern = Pattern.compile("(?=.*[A-Z])");
        Pattern lowerCasePattern = Pattern.compile("(?=.*[a-z])");
        Pattern specialCharacterPattern = Pattern.compile("(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+])");
        Pattern lengthPattern = Pattern.compile(".*{6,}");
        Matcher m1 = numberPattern.matcher(s);
        Matcher m2 = upperCasePattern.matcher(s);
        Matcher m3 = lowerCasePattern.matcher(s);
        Matcher m4 = specialCharacterPattern.matcher(s);
        Matcher m5 = lengthPattern.matcher(s);
        if(m1.find()) {

            count++;
        }
        if(!m2.find()) {
            count++;
        }
        if(!m3.find()) {
            count++;
        }
        if(!m4.find()) {
            count++;
        }
        if(length+count<6) {
            count = count + (6-(length+count));
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String s = "#Hacke3rRank1";
        int result = strongPassword(s);
        System.out.println(result);
    }
}
