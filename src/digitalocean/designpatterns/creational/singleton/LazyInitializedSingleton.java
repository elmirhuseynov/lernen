package digitalocean.designpatterns.creational.singleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) { // it is not thread safe
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
