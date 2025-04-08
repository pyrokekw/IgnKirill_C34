import task1.ThreadByInheritance;
import task1.ThreadByInterfaceRunnable;
import task2.MaxThread;
import task2.MinThread;
import task3.DaemonTask;

public class MainApp {

    public static void main(String[] args) {
        // Задача 1)
        //Создать поток используя два способа - через наследованное и имплементируя интерфейс Runnable
        //Оба потока должны стартовать, после чего основной поток должен дождаться их завершения и прекратить работу.
        ThreadByInheritance thread1 = new ThreadByInheritance();
        Thread thread2 = new Thread(new ThreadByInterfaceRunnable());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Задача 2)
        //Есть массив целых чисел.
        //Необходимо создать два потока - один из которых будет считать максимальное значение, а второй - минимальное.
        //Запустить оба потока и дождаться их окончания. Вывести на экран результат вычислений.
        int[] numbers = {1, 10, 17, 6, 9, 25};

        MaxThread maxFinder = new MaxThread(numbers);
        MinThread minFinder = new MinThread(numbers);

        Thread maxThread = new Thread(maxFinder);
        Thread minThread = new Thread(minFinder);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Max = " + maxFinder.getMaxNum());
        System.out.println("Min = " + minFinder.getMinNum());

        //Задача 3)
        //Создать поток демон и проверить его работу
        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            daemonThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Главный поток закончил работу.");
    }
}
