package challenges.tt;

public class IntegerTest {

    private static final Integer INTEGER_1 = 150;
    private static final Integer INTEGER_2 = 10;

    public static void main(String[] args) {

        compare1();
        compare2();
        compare3();
        compare4();
    }

    private static void compare1() {
        Integer integer1 = Integer.valueOf(INTEGER_1);
        Integer integer2 = Integer.valueOf(INTEGER_1);
        System.out.println(integer1 == integer2);
    }

    private static void compare2() {
        Integer integer1 = Integer.valueOf(INTEGER_2);
        Integer integer2 = Integer.valueOf(INTEGER_2);
        System.out.println(integer1 == integer2);
    }

    private static void compare3() {
        Integer integer1 = INTEGER_1;
        Integer integer2 = INTEGER_1;
        System.out.println(integer1 == integer2);
    }

    private static void compare4() {
        Integer integer1 = INTEGER_2;
        Integer integer2 = INTEGER_2;
        System.out.println(integer1 == integer2);
    }

}
