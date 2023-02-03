package baeldung.threadsafety.synchronizedcollections_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Test {

    // This means that the methods can be accessed by only one thread at a time,
    // while other threads will be blocked until the method is unlocked by the first thread.
    // Thus, synchronization has a penalty in performance, due to the underlying logic of synchronized access.
    public static void main(String[] args) {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            }
        });
        Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));

        thread1.start();
        thread2.start();

        syncCollection.forEach(System.out::println);
    }

}
