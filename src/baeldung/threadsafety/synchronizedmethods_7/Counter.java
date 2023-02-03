package baeldung.threadsafety.synchronizedmethods_7;

public class Counter {

    private int counter;

    // It is thread safe method
    /**
     * Simply put, only one thread can access a synchronized method at a time,
     * while blocking access to this method from other threads.
     * Other threads will remain blocked until the first thread finishes or the method throws an exception.
    */
    public synchronized void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
