package domain;

public enum Position {
    DIRECTOR(10000),
    MANAGER(5000);
    private int baseSalary;
    Position(int baseSalary) {
        this.baseSalary = baseSalary;
    }
    public int getBaseSalary() {
        return baseSalary;
    }
}
