package patterns.threads;

import patterns.singleton.DoubleCheckedSingleton;

public class ThreadSub implements Runnable{
    @Override
    public void run() {
        DoubleCheckedSingleton singleton = DoubleCheckedSingleton.getInstance("Sub");
        System.out.println(singleton);
    }
}
