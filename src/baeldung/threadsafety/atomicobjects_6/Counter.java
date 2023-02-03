package baeldung.threadsafety.atomicobjects_6;

public class Counter {

    private int counter;

    // not thread safe
    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}
