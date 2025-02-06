import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // First task
        // Дано произвольное число. Необходимо узнать, сколько в конце числа нулей.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число:");
        int number = scanner.nextInt();
        int lastnum;
        int count = 0;
        while (true) {
            lastnum = number % 10;
            if (lastnum == 0) {
                count++;
                number = number / 10;
            }
            else {
                break;
            }
        }
        System.out.println("Количество нулей в конце = " + count);
        // Second task
        // Необходимо найти интервал числа n (интервал это произведение всех целых чисел от 1 до n)
        System.out.print("Введите число для 2 задачи:");
        int n = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Интервал числа " + n + " равен = " + result ); // вроде периодом называется
        // Third task
        // Пользователь вводит два числа. Необходимо найти среднее арифметическое между заданными числами (сумма чисел / количество чисел)
        System.out.print("Введите 1 число: ");
        double number1 = scanner.nextDouble();
        System.out.print("Введите 2 число: ");
        double number2 = scanner.nextDouble();
        System.out.println("Среднее арифметическое = " + (number1+number2)/2);
    }
}
