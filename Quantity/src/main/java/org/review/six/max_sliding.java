package org.review.six;

import java.util.Arrays;

public class max_sliding {
    public static void main(String[] args){
        int[] nums = {3, 1, -3, 2, -1, 5};
        int k = 3;

        int left = 0, right = k - 1;
        int[] result = new int[nums.length - k + 1];

        while (right <= nums.length - 1) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            result[left] = max;
            left++;
            right++;
        }
        System.out.println(Arrays.toString(result));
    }
}