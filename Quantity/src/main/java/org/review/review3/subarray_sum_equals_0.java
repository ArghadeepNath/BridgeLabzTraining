package review;

import java.util.*;

public class subarray_sum_equals_0 {
    public static void main(String[] args){
        int[] arr = {4,2,1,6,-6};
        int sum = 0;
        boolean found = false;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(set.contains(sum)){
                found = true;
                break;
            }
            set.add(sum);
        }
        if(found){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

}
