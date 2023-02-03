package baeldung.threadsafety.synchronizedstatements_8;

public class Counter {

    private int counter;

    public void incrementCounter() {
        synchronized (this) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
