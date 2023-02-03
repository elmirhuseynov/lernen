package baeldung.threadsafety.threadlocal_3;

import java.util.Arrays;
import java.util.List;

//The class have their own state, but it's not shared with other threads. So, this class is thread-safe.
public class ThreadIntTest extends Thread {

    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }

}
