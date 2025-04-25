public class Worker {

    private String name;
    private Integer salary;

    public Worker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
