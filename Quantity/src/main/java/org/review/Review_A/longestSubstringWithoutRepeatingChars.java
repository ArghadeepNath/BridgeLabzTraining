package org.review.Review_A;

import java.util.*;

public class longestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {

        String str = "ABDEFGABEF";
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int len = 0;

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            while (map.containsKey(c)) {
                map.remove(str.charAt(left));
                left++;
            }
            map.put(c, 1);
            len = Math.max(len, right - left + 1);
            System.out.println(str.substring(left, right + 1));
        }

        System.out.println("Longest length: " + len);
    }
}