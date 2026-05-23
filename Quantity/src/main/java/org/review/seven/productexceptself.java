package org.review.seven;

public class productexceptself {
    public static void main(String[] args){
        int[] input = {1,2,3,4};
        int[] result= new int[input.length];
        for(int i=0;i<input.length;i++){
            int product=1;
            for(int j=0;j<input.length;j++){
                if(i!=j){
                    product*=input[j];
                }
            }
            result[i]=product;

        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
