package org.review.Review_A;

public class aep_Present {
    public static void main(String[] args){
        String s="Hello I am Arghadeep";
        boolean a=false,e=false,p=false;
        for(char c:s.toCharArray()){
            if(c=='a') a=true;
            else if(c=='e') e=true;
            else if(c=='p') p=true;
        }
        if(a&&e&&p) System.out.println("All Present");
        else if(a||e||p) System.out.println("One or More Present");
        else System.out.println("None Present");
    }
}
