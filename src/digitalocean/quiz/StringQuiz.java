package digitalocean.quiz;

public class StringQuiz {

    public static void main(String[] args) {
        //q1();
        //q2();
        //q3();
        //q4();
        q5();
    }

    static void q5() {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s2.intern());
    }

    static void q4() {
        String s = "Java" + 1 + 2 + "Quiz" + "" + (3 + 4);
        System.out.println(s);
    }

    static void q3() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 is: " + s1 == s2);
    }

//    static void q2() {
//        String s = "Java String Quiz";
//        System.out.println(s.substring(5, 3));
//    }

//    static void q1() {
//        String s = "Java String Quiz";
//        System.out.println(s.charAt(s.toUpperCase().length()));
//    }

}
