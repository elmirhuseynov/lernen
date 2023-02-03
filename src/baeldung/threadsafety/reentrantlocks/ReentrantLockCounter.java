package baeldung.threadsafety.reentrantlocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {

    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }

    // standard constructors / getter

}
