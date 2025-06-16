package patterns.singleton;

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;
    private String value;

    private DoubleCheckedSingleton(String value) {
        this.value = value;
    }

    public static DoubleCheckedSingleton getInstance(String value) {
        if (instance != null) {
            return instance;
        }
        synchronized (DoubleCheckedSingleton.class) {
            if (instance == null) {
                instance = new DoubleCheckedSingleton(value);
            }
            return instance;
        }
    }

    @Override
    public String toString() {
        return "value='" + value + '\'';
    }
}
