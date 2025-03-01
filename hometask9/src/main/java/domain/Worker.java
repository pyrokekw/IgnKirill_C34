package domain;

public class Worker extends Employee{
    public Worker(String firstName, String lastName, int experience) {
        super(firstName, lastName, experience, Position.WORKER);
    }
}
