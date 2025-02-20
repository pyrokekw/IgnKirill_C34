import secondTask.Cat;
import secondTask.Dog;
import thirdTask.Student;
import thirdTask.StudentService;

public class MainApp {

    //1) Создать метод, который принимает два целых числа. Данный метод должен вернуть максимальное число.
    public static int getMax(int firstNumber, int secondNumber) {
        return (firstNumber > secondNumber) ? firstNumber : secondNumber;
    }

    //2) Необходимо создать два перегруженных метода print. Один метод принимает обьект Cat,
    // а второй объект Dog. Каждый из методов должен вернуть кличку животного.

    public static String printName(Cat cat) {
        return "Кличка кота: " + cat.getName();
    }

    public static String printName(Dog dog) {
        return "Кличка собаки: " + dog.getName();
    }

    public static void main(String[] args) {
        //////
        int x = 5;
        int y = 10;
        System.out.println(getMax(x,y) );
        /////
        Cat myCat = new Cat("Кит");
        Dog myDog = new Dog("Сибака");
        System.out.println(printName(myCat));
        System.out.println(printName(myDog));
        /////
        //3) Необходимо создать объект Student со следующими полями
        //a) имя студента
        //b) возраст студента
        //с) номер группы.
        //Создать StudentService класс, с методом который принимает массив студентов и номер группы.
        // Данный метод должен вернуть количество студентов, которые относятся к данной группе.
        Student[] students = {
                new Student("Alex", 20, 40),
                new Student("Bob", 19, 41),
                new Student("Sofia", 21, 41),
                new Student("Jake", 18, 40),
                new Student("John", 20, 41)
        };

        System.out.println("Количество студентов выбранной группы: " + StudentService.countGroupStudent(students, 41));

    }
}
