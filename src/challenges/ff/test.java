//package ocp.codingchallenges.ff;
//
//import java.io.Serializable;
//import java.util.Collections;
//import java.util.List;
//
//public class test<T, U> {
//
//    static <T extends Serializable & Comparable<? super T>> T max(List<T> list) {
//        return list != null ? Collections.max(list) : null;
//    }
//
//    public static void main(String[] args) {
//        test<String, Integer> genericMethods = new test<>();
//
//        List<A> listA = null;
//        List<B> listB = null;
//        List<C> listC = null;
//        List<D> listD = null;
//        List<K> listK = null;
//
//        test.max(listA);
//        test.max(listB);
//        test.max(listC);
//        test.max(listD);
//        test.max(listK);
//    }
//}
//
//class A implements Serializable {
//}
//
//class B implements Serializable, Comparable<A> {
//    @Override
//    public int compareTo(A o) {
//        return 0;
//    }
//}
//
//class C extends A implements Serializable, Comparable<C> {
//    @Override
//    public int compareTo(C o) {
//        return 0;
//    }
//
//}
//
//class D extends A implements Serializable, Comparable {
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
//
//class K extends A implements Comparable<Object> {
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
