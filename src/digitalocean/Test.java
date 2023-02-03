package digitalocean;

public class Test {

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
    }

//    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = new String("abc");
//        s2.intern();
//        System.out.println(s1 == s2);
//    }

//    public static void main(String[] args) {
//        String s1 = "abc";
//        StringBuffer s2 = new StringBuffer(s1);
//        System.out.println(s1.equals(s2));
//    }


//    public static void main(String[] args) {
//        String s1 = new String("pankaj");
//        String s2 = new String("PANKAJ");
//        System.out.println(s1 = s2);
//    }


//    public static void main(String[] args) {
//        String str  =  new String("abc");
//        char[] a = {'a', 'b', 'c'};
//        String str2  =  new String(a);
//
//        System.out.println(str == str2);
//
//        ///------------------//
//        String s1 = "pankaj";
//        String s2 = "pankaj";
//        String s3 = new String("pankaj");
//
//        System.out.println(s1 == s2);//true
//        System.out.println(s2 == s3);//false
//
//        String s4 = s3.intern();
//        System.out.println(s1 == s4);//true
//        ////------------
//
//        new Test().foo("s");
//    }

    public void foo(String s) {
        System.out.println("String".hashCode());
    }

    public void foo(StringBuffer sb){
        System.out.println("StringBuffer");
    }

}
