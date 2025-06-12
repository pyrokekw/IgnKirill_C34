import patterns.builder.Employee;
import patterns.builder.EmployeeBuilder;
import patterns.threads.ThreadDava;
import patterns.threads.ThreadSub;
import patterns.singleton.Singleton;

public class MainApp {

    public static void main(String[] args) {
        // Тест Синглтона (Одиночка)
        // -
        // Единственный экземпляр класса + видимость везде
        Singleton singleton = Singleton.getInstance("Sub");
        Singleton newSingleton = Singleton.getInstance("Dava");

        System.out.println(singleton);
        System.out.println(newSingleton);

        // Многопоточный Сингл

        Thread threadSub = new Thread(new ThreadSub());
        Thread threadDava = new Thread(new ThreadDava());
        threadSub.start();
        threadDava.start();

        //Билдер
        Employee emp1 = new EmployeeBuilder()
                .setFN("Alex")
                .setLN("Right")
                .setYO(20)
                .setSalary(222.2)
                .build();

        System.out.println(emp1);
    }

}
