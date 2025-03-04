package domain;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int experience;
    private Position position;

    public Employee(String firstName, String lastName, int experience, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperience() {
        return experience;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experience=" + experience +
                ", position=" + position +
                '}';
    }
}
