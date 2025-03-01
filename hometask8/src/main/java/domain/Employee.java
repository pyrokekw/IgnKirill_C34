package domain;

public class Employee {
    private String name;
    private int experience;
    private Position position;

    public Employee(String name, int experience, Position position) {
        this.name = name;
        this.experience = experience;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public Position getPosition() {
        return position;
    }

    public double calculateSalary() {
        // добавляем 15% за каждый год стажа
        double bonus = position.getBaseSalary() * 0.15 * experience;
        return position.getBaseSalary() + bonus;
    }
}