package org.review.seven;
import java.util.*;

public class Daily_Temperatures {
    public static void main(String[] args){
        int[] input = {73,74,75,71,69,72,76,73};
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];
        for(int i=0; i<input.length; i++){
            while(!stack.isEmpty() && input[stack.peek()]<input[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
