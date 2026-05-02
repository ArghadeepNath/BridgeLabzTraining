package org.review.Review_A;
import java.util.*;

public class freqElements {
    public static void main(String[] args) {
        String[] input = {"apple", "banana", "apple", "orange"};
        HashMap<String, Integer> map = new HashMap<>();
        int n = input.length;
        for (String s : input) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
    }
}
