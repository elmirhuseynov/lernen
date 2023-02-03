package baeldung.threadsafety.synchronizedstatements_8;

// Other Objects as a Lock
public class ObjectLockCounter {

    private int counter;
    private final Object lock = new Object();

    public void incrementCounter() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

}
