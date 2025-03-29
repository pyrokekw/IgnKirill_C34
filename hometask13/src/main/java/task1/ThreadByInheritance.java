package task1;

public class ThreadByInheritance extends Thread {
    @Override
    public void run() {
        System.out.println("Поток через наследование работает...");
    }
}
