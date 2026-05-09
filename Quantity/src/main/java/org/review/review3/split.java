package review;
import java.util.*;
import java.util.regex.*;
public class split {
    public static void main (String[] args){
        String s = "Java,Python,C++,React";
        Pattern pattern= Pattern.compile("[^,]+");
        Matcher matcher = pattern.matcher(s);

        List<String> list = new ArrayList<>();

        while(matcher.find()){
            list.add(matcher.group());
        }
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

//