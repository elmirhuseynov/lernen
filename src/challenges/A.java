package challenges;

public enum A {

    ONE("1"),
    TWO("2"),
    THREE("3");

    A(String a) {
        System.out.print(a + " ");
    }

    public static void main(String[] args) {
        A a1 = A.ONE;
        A a2 = A.ONE;
        A a3 = A.TWO;
    }
}
