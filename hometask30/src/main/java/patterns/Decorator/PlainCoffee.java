package patterns.Decorator;

public class PlainCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Обычный кофе";
    }

    @Override
    public int getCost() {
        return 2;
    }
}
