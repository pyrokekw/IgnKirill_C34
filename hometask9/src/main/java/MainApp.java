import domain.*;

public class MainApp {

    public static void main(String[] args) {
        Worker worker1 = new Worker("Alex", "Siuhy", 1);
        Worker worker2 = new Worker("Anya", "Black", 4);
        Worker worker3 = new Worker("Sasha", "Rue", 6);
        Director director1 = new Director("Kirill", "Soul", 15);
        // 1) Создать 3 работников и 1 директора
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(worker3);
        // 2) Назначить двух созданных сотрудников под управление директора. Распечатать сведения о директоре
        director1.addSubs(worker1);
        director1.addSubs(worker2);
        System.out.println(director1);
        // 3) Создать нового директора с одним сотрудником (под управлением)
        // и добавить его под управления существующего директора.
        Director director2 = new Director("Paul", "Walker", 10);
        director2.addSubs(worker3);
        director1.addSubs(director2);
        // 4) Убедиться, что сведения о первом директоре теперь включают сведения о втором, который
        // так же добавлен к нему (и т.д.).
        System.out.println(director1);
        // 5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном)
        // сотрудник с указанным именем (поиск вглубь)
        System.out.println("\nEmployee Search:");
        System.out.println("Has employee 'Alex': " + DirectorService.isEmployeeName(director1, "Alex"));
        System.out.println("Has employee 'Anya': " + DirectorService.isEmployeeName(director1, "Anya"));
        System.out.println("Has employee 'Bob': " + DirectorService.isEmployeeName(director1, "Bob"));
    }

}