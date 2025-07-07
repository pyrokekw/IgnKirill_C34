package patterns.Template;

public class TeaMaker extends BeverageMaker {
    @Override
    void brew() {
        System.out.println("Завариваем чай...");
    }
}
