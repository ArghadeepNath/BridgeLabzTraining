package review;

import java.util.regex.*;

public class pan_card_validation {
    public static void main(String[] args){
        //Write a Java program to validate an Indian PAN card number using Regular Expressions.
        //Requirements:
        //1. PAN format should be:
        //○ 5 uppercase letters
        //○ 4 digits
        //○ 1 uppercase letter
        //2. Print valid or invalid PAN.

        String input="ABCDE1234F";
        String pattern = "^[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(input);
        if(mat.matches()) System.out.print("Yes");
        else System.out.print("No");
    }
}
