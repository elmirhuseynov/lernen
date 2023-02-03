package digitalocean.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        //ConcurrentHashMap
        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");

        System.out.println("ConcurrentHashMap before iterator: " + myMap);
        for (String key : myMap.keySet()) {
            if (key.equals("3")) {
                myMap.put(key + "new", "new3");
                //myMap.put(key, "new3");
            }
        }
        System.out.println("ConcurrentHashMap after iterator: " + myMap);

        //HashMap
        myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");

        System.out.println("HashMap before iterator: " + myMap);
        for (String key : myMap.keySet()) {
            if (key.equals("3")) {
                myMap.put(key + "new", "new3");
                //myMap.put(key, "new3");
            }
        }
        System.out.println("HashMap after iterator: " + myMap);
    }

}