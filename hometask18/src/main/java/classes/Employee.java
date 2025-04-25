package classes;


public class Employee {

    private String name;
    private Profession profession;
    private double salary;

    public Employee(String name, Profession profession, double salary) {
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", profession=" + profession +
                ", salary=" + salary +
                '}';
    }
}
