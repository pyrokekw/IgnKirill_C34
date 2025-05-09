import classes.Employee;
import classes.Profession;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {

        List<Employee> workers = Arrays.asList(
                new Employee("Alex", Profession.ENGINEER, 2000),
                new Employee("Sandi", Profession.MANAGER, 2500),
                new Employee("Helen", Profession.DIRECTOR, 3000),
                new Employee("Leo", Profession.MANAGER, 3000),
                new Employee("Scaly", Profession.ENGINEER, 1500),
                new Employee("John", Profession.ENGINEER, 2500)
        );

        //1) Среднюю зп по профессиям

        workers.stream()
                .collect(Collectors.groupingBy(
                        Employee::getProfession,
                        Collectors.averagingDouble(Employee::getSalary)))
                .forEach(((profession, avgSalary) ->
                        System.out.println(profession + " " + avgSalary)));

        //2) Сколько работников относится к каждой из профессий

        workers.stream()
                .collect(Collectors.groupingBy(
                        Employee::getProfession,
                        Collectors.counting()
                ))
                .forEach(((profession, count) ->
                        System.out.println(profession + " " + count)));

        //3) Сколько компания тратит денег на зп каждой профессии

        workers.stream()
                .collect(Collectors.groupingBy(
                        Employee::getProfession,
                        Collectors.summingDouble(Employee::getSalary)
                ))
                .forEach(((profession, sum) ->
                        System.out.println(profession + " " + sum)));
    }

}
