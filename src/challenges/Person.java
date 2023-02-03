package challenges;

import java.util.HashSet;

public class Person {
    private static int hasher = 100;

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int hashCode() {
        return hasher++;
    }

    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return person.age == this.age;
    }

    public String toString() {
        return Integer.toString(age);
    }

    public static void main(String[] args) {

        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);

        HashSet<Person> hashSet = new HashSet<>();

        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);

        System.out.println(hashSet);
        System.out.println(hashSet.contains(p1));

        System.out.println(hashSet.contains(p2));

        System.out.println(hashSet.contains(p3));

    }

}