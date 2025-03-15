package domain;

public class EmployeeService {
    public void printSalary(Employee employee) {
        System.out.println("Сотрудник: " + employee.getName());
        System.out.println("Получил зарплату в размере: " + employee.calculateSalary());
    }
}
