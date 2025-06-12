package patterns.builder;

public class Employee {

    private String firstName;
    private String lastName;
    private int yearsOld;
    private double salary;

    public Employee(EmployeeBuilder empBuilder) {
        this.firstName = empBuilder.getFirstName();
        this.lastName = empBuilder.getLastName();
        this.yearsOld = empBuilder.getYearsOld();
        this.salary = empBuilder.getSalary();
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearsOld=" + yearsOld +
                ", salary=" + salary;
    }
}
