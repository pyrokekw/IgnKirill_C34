package patterns.builder;

public class EmployeeBuilder {

    private String firstName;
    private String lastName;
    private int yearsOld;
    private double salary;

    public EmployeeBuilder(){
        super();
    }

    public EmployeeBuilder setFN(String firstName){
        this.firstName=firstName;
        return this;
    }

    public EmployeeBuilder setLN(String lastName){
        this.lastName=lastName;
        return this;
    }

    public EmployeeBuilder setYO(int yearsOld) {
        this.yearsOld = yearsOld;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        Employee emp = new Employee(this);
        return emp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public double getSalary() {
        return salary;
    }
}
