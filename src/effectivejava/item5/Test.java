package effectivejava.item5;

import java.util.List;

public class Test {

    public static void main(String[] args) {
//        var aBoolean = Boolean.valueOf("true");
//        Collections.synchronizedList();
//        EnumSet.of();

        // Item 5: Avoid creating unnecessary objects
//        String s = new String("stringette"); // DON'T DO THIS!

//        Person p = new Person(new Date());
//
//        System.out.println(p.isBabyBoomer1());
//        System.out.println(p.isBabyBoomer1());
//        System.out.println(p.isBabyBoomer1());
//        System.out.println(p.isBabyBoomer1());
//        System.out.println(p.isBabyBoomer1());
        //------
        long start = System.currentTimeMillis();
        Long sum = 0L; //<-long
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("Time: " + (System.currentTimeMillis() - start));

        //-----
        Integer i = Integer.valueOf(10);

        // Autoboxing of character
        Character gfg = 'a';

        // Auto-unboxing of Character
        char ch = gfg;
        //---

    }

    // Method 1
    // To sum odd numbers
    public static int sumOfOddNumber(List<Integer> list) {

        // Initially setting sum to zero
        int sum = 0;

        for (Integer i : list) {

            // Unboxing of i automatically
            if (i % 2 != 0)
                sum += i;

            // Unboxing of i is done automatically
            // using intvalue implicitly
            if (i.intValue() % 2 != 0)
                sum += i.intValue();
        }

        // Returning the odd sum
        return sum;
    }
}
