package patterns.singleton;

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;
    private String value;

    private DoubleCheckedSingleton(String value) {
        this.value = value;
    }

    public static DoubleCheckedSingleton getInstance(String value) {
        DoubleCheckedSingleton res = instance;
        if (res != null) {
            return res;
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
