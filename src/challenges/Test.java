package challenges;

import java.util.Optional;
import java.util.function.Predicate;

public class Test {

//    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
//
//        for (int i = 0, n = arrayList.size(); i < n; i++) {
//            arrayList.add(100);
//        }
//
//        System.out.println(arrayList);
//    }

//    public static void main(String[] args) {
//        Comparator<? super Integer> comparator = new Comparator<Number>() {
//
//            @Override
//            public int compare(Number o1, Number o2) {
//                return o1.intValue() - o2.intValue();
//            }
//
//        };
//        System.out.println(comparator.compare(1.11d, 1.21d));
//    }

//    public static void main(String[] args) {
//        Set<Short> shorts = new HashSet<>();
//        for (short i = 0; i < 50; i++) {
//            shorts.add(i);
//            shorts.remove(i - 1);
//        }
//
//        System.out.println(shorts.size());
//    }

//    public static void main(String[] args) {
//        System.out.println(
//                Stream.of(1, 2, 3, 4)
//                        .map(i -> null)
//                        .findFirst()
//        );
//    }

    //--------- Widening > Boxing > Varargs
//    static void test(Object... args) {
//        System.out.println("Object... array");
//    }
//
//    static void test(Object arg) {
//        System.out.println("Object");
//    }
//
//    static void test(short arg) {
//        System.out.println("short");
//    }
//
//    static void test(int arg) {
//        System.out.println("int");
//    }
//
//    static void test(Integer arg) {
//        System.out.println("Integer");
//    }
//
//    static void test(long arg) {
//        System.out.println("long");
//    }
//
//    static void test(Long arg) {
//        System.out.println("Long");
//    }
//
//    public static void main(String[] args) {
//        test(3);
//        test(Integer.valueOf(3));
//        test(new Long(3));
//    }
    //---------

//    public static void main(String[] args) {
//        String s = "Taleh";
//        List<String> list = new ArrayList<>();
//        list.add(s);
//        list.add(s);
//        list.add(s);
//        Stream<String> stream = list.stream();
//        list.add(s);
//        System.out.println(stream.count());
//
///* What is the output from this code?
//   And what if we change the line 2 with the following code?
//
//          List<String> list = new ArrayList<>();
//          list.add(s);
//		  list.add(s);
//          list.add(s);
//*/
//    }
}
