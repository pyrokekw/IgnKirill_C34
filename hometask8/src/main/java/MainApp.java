import domain.Employee;
import domain.EmployeeNew;
import domain.EmployeeService;
import domain.Position;

public class MainApp {

    public static void main(String[] args) {
        Employee alex = new Employee("Alex", 3, Position.MANAGER);
        Employee steve = new EmployeeNew("Steve", 6, Position.DIRECTOR);

        EmployeeService employeeService = new EmployeeService();

        employeeService.printSalary(alex);
        employeeService.printSalary(steve);

    }
}