import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {

        //1) Есть коллекция пользователей. У каждого пользователя есть уникально поле - login.
        // Необходимо на основе данной коллекции создать map где ключ - это логин, а значение сам объект пользователь.

        Collection<User> users = List.of(
                new User("user1"),
                new User("user2"),
                new User("user3")
        );

        Map<String, User> usersMap = new HashMap<>();

        for (User user: users) {
            usersMap.put(user.getLogin(), user);
        }

        System.out.println(usersMap);

        //2) Есть массив слов. Необходимо создать map где ключ - это слово из массива, а значение - это его длинна.
        String[] words = {"apple", "joy", "friend", "process"};
        Map<String,Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            wordsMap.put(word, word.length());
        }

        System.out.println(wordsMap);

    }

}
