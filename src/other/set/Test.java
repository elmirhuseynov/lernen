package other.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(1);
        set.add(1);
        System.out.println("set: " + set);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(4);
        linkedHashSet.add(2);
        linkedHashSet.add(5);
        System.out.println("linkedHashSet: " + linkedHashSet);
        ///-------

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person(4));
        personSet.add(new Person(2));
        personSet.add(new Person(1));
        personSet.add(new Person(1));
        System.out.println(personSet);

        Set<Person> personLinkedHashSet = new LinkedHashSet<>();
        personLinkedHashSet.add(new Person(4));
        personLinkedHashSet.add(new Person(2));
        personLinkedHashSet.add(new Person(1));
        personLinkedHashSet.add(new Person(1));
        System.out.println(personLinkedHashSet);
    }

}
