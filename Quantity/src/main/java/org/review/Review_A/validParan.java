package org.review.Review_A;

import java.util.*;

public class validParan {
    public static void main(String[] args) {

        String input1 = "()[]{}";
        Stack<Character> stack = new Stack<>();
        boolean flag = true;

        for (char c : input1.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) flag = false;
        System.out.println(flag ? "Valid" : "Not Valid");
    }
}