package digitalocean.immutable;

import java.util.HashMap;

public final class DeepCopyExample {

    private final int id;

    private final String name;

    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    /**
     * Constructor performing Deep Copy
     *
     * @param i
     * @param n
     * @param hm
     */

    public DeepCopyExample(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = i;
        this.name = n;

        HashMap<String, String> tempMap = new HashMap<>();
        for (String key : hm.keySet()) {
            tempMap.put(key, hm.get(key));
        }

        this.testMap = tempMap;
    }

    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        DeepCopyExample example = new DeepCopyExample(i, s, h1);

        //Let's see whether its copy by field or reference
        System.out.println(s == example.getName());
        System.out.println(h1 == example.getTestMap());
        //print the ce values
        System.out.println("ce id:" + example.getId());
        System.out.println("ce name:" + example.getName());
        System.out.println("ce testMap:" + example.getTestMap());

        //change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");

        //print the values again
        System.out.println("ce id after local variable change:" + example.getId());
        System.out.println("ce name after local variable change:" + example.getName());
        System.out.println("ce testMap after local variable change:" + example.getTestMap());

        HashMap<String, String> hmTest = example.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + example.getTestMap());
    }

}