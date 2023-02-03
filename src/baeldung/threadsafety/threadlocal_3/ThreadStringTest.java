package baeldung.threadsafety.threadlocal_3;

import java.util.Arrays;
import java.util.List;

//The class have their own state, but it's not shared with other threads. So, this class is thread-safe.
public class ThreadStringTest extends Thread {

    private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");

    @Override
    public void run() {
        letters.forEach(System.out::println);
    }

}
