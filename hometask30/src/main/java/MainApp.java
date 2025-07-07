import patterns.Decorator.Coffee;
import patterns.Decorator.MilkDecorator;
import patterns.Decorator.PlainCoffee;
import patterns.Template.BeverageMaker;
import patterns.Template.CoffeeMaker;
import patterns.Template.TeaMaker;

public class MainApp {


    public static void main(String[] args) {
        // Декоратор
        Coffee coffee = new PlainCoffee();
        System.out.println("Описание: " + coffee.getDescription());
        System.out.println("Цена: " + coffee.getCost());

        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println("Описание: " + milkCoffee.getDescription());
        System.out.println("Цена: " + milkCoffee.getCost());

        // Шаблонный метод
        BeverageMaker tea = new TeaMaker();
        tea.makeBeverage();

        BeverageMaker coffeeMake = new CoffeeMaker();
        coffeeMake.makeBeverage();
    }
}
