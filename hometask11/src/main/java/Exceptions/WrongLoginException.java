package Exceptions;

public class WrongLoginException extends Exception{
    public WrongLoginException() {
        super("Недопустимый логин");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
