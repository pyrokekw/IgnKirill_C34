package Exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Недопустимый пароль");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
