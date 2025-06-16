package patterns.threads;

import patterns.singleton.DoubleCheckedSingleton;

public class ThreadDava implements Runnable{
    @Override
    public void run() {
        DoubleCheckedSingleton singleton = DoubleCheckedSingleton.getInstance("Dava");
        System.out.println(singleton);
    }
}
