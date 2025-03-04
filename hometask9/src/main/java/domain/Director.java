package domain;

import java.util.Arrays;

public class Director extends Employee{
    private Employee[] subordinates;
    private int subordinateCount;

    public Director(String firstName, String lastName, int experience) {
        super(firstName, lastName, experience, Position.DIRECTOR);
        this.subordinates = new Employee[6];
        this.subordinateCount = 0;
    }

    public void addSubs (Employee employee) {
        if (subordinateCount < subordinates.length) {
            subordinates[subordinateCount++] = employee;
        }
    }

    public Employee[] getSubordinates() {
        return Arrays.copyOf(subordinates, subordinateCount); // возвращаем только заполненые
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experience=" + experience +
                ", position=" + position +
                " subordinates=" + Arrays.toString(subordinates) + '}';
    }
}
