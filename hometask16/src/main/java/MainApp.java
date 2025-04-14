import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainApp {

    public static void main(String[] args) {

        //При помощи lambda необходимо создать реализации для основных функциональных интерфейсов
        //1) Predicate
        //2) Consumer
        //3) Supplier
        //4) Function

        Predicate<Integer> moreThan10 = num -> num > 10;
        System.out.println("Число 20 больше 10? - " + moreThan10.test(20) );

        Consumer<String> stringPrinter = str -> System.out.println("Output: " + str);
        stringPrinter.accept("Hello, World!");

        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);
        System.out.println("Рандомное число: " + randomNumberSupplier.get());

        Function<String, String> toUpperCase = str -> str.toUpperCase();
        System.out.println(toUpperCase.apply("hello"));

        //Так же необходимо создать класс Worker (с полем зарплата) и заполнить TreeSet,
        // в качестве Comparator передать lambda - которая сортирует по величине зарплаты

        TreeSet<Worker> workers = new TreeSet<>(Comparator.comparingInt(Worker::getSalary));
        workers.add(new Worker("Alex", 55000));
        workers.add(new Worker("Ben", 6000));
        workers.add(new Worker("Jade", 22000));
        workers.add(new Worker("Rin", 2000));
        workers.add(new Worker("Gray", 80000));

        System.out.println(workers);



    }

}
