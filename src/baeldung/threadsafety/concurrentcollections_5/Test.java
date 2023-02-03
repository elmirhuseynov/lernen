package baeldung.threadsafety.concurrentcollections_5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    /** Unlike their synchronized counterparts, concurrent collections achieve thread-safety by dividing their data into segments.
     * In a ConcurrentHashMap, for example, several threads can acquire locks on different map segments,
     * so multiple threads can access the Map at the same time.*/
    // Concurrent collections are much more performant than synchronized collections
    public static void main(String[] args) {
        Map<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");

        System.out.println(concurrentMap);
    }

}
