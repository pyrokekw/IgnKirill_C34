package domain;

public class EmployeeNew extends Employee{
    public EmployeeNew(String name, int experience, Position position) {
        super(name, experience, position);
    }

    @Override
    public double calculateSalary() {
        double baseSalary = getPosition().getBaseSalary();
        double addBonus = baseSalary * 0.2;
        return baseSalary + addBonus;
    }
}
