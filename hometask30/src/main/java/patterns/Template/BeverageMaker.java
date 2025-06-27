package patterns.Template;

abstract public class BeverageMaker {

    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
    }

    abstract void brew();

    void boilWater() {
        System.out.println("Кипятиться вода...");
    }

    void pourInCup() {
        System.out.println("Налили в кружку");
    }
}
