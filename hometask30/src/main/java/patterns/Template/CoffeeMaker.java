package patterns.Template;

public class CoffeeMaker extends BeverageMaker{
    @Override
    void brew() {
        System.out.println("Завариваем кофе...");
    }
}
