package baeldung.threadsafety.threadlocal_3;

public class ThreadState {

    public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<>() {
        @Override
        protected StateHolder initialValue() {
            return new StateHolder("active");
        }
    };

    public static StateHolder getState() {
        return statePerThread.get();
    }

}
