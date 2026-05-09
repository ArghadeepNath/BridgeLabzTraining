package review;

import java.util.*;

public class map_ascending {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("Nepal","Kathmandu");
        map.put("India","New Delhi");
        map.put("USA","Washington");
        map.put("England","London");

        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        LinkedHashMap<String,String> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String,String> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<String,String> entry : sortedMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
