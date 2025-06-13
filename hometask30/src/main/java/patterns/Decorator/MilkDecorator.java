package patterns.Decorator;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + MILK.";
    }

    @Override
    public int getCost() {
        return super.getCost() + 1;
    }
}
