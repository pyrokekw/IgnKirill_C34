package thirdTask;

public class StudentService {

    public static int countGroupStudent(Student[] students, int numberGroup) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getNumberGroup() == numberGroup) {
                count++;
            }
        }
        return count;
    }

}
