package task3;

public class DaemonTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Демон поток начал работу...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Демон поток закончил работу.");
    }
}
