import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;
import Validation.Valid;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Введите логин: ");
            String login = scan.nextLine();
            System.out.println("Введите пароль: ");
            String password = scan.nextLine();
            System.out.println("Подтвердите пароль: ");
            String confirmPassword = scan.nextLine();
            Valid.validateData(login,password,confirmPassword);
            System.out.println("Validation successful!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}