package thirdTask;

public class Student {

    private String name;
    private int age;
    private int numberGroup;

    public Student(String name, int age, int numberGroup) {
        this.name = name;
        this.age = age;
        this.numberGroup = numberGroup;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getNumberGroup(){
        return numberGroup;
    }
}
