package Validation;

import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Valid {
    public static boolean validateData(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (login.length() >= 20 || login.contains(" ")) {
            throw new WrongLoginException("Логин должен быть менее 20 символов и не содержать пробелов");
        }
        if (!password.matches("^(?=.*\\d)[^\\s]{1,19}$")) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов и содержать хотя бы 1 цифру," +
                    " не должен содержать пробелов");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли отличаются");
        }

        return true;
    }
}
