package task1;

public class ThreadByInterfaceRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Поток от интерфейса работает...");
    }
}
