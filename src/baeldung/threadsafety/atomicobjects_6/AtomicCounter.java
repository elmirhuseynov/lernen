package baeldung.threadsafety.atomicobjects_6;

import java.util.concurrent.atomic.AtomicInteger;

//Atomic classes allow us to perform atomic operations, which are thread-safe, without using synchronization
public class AtomicCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}