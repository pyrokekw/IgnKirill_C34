import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {

        //Имеется коллекция чисел. При помощи stream api необходимо
        Collection<Integer> numbers = Arrays.asList(20,12,6,5,3,8,16,21,1,9,9,9,21);
        //1) вывести только четные
        System.out.println(numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList()));
        //2) получить коллекцию без дубликатов (используя distinct)
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.toList()));
        //3) получить сумму всех чисел
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        //4) получить максимальный элемент в коллекции
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        max.ifPresent(
                System.out::println
        );
        //5) найти первый элемент, который больше 10
        OptionalInt firstMoreTen = numbers.stream()
                .filter(num -> num > 10)
                .mapToInt(Integer::intValue)
                .findFirst();
        firstMoreTen.ifPresent(
                System.out::println
        );
        //6) определить все ли числа делятся на 10 без остатка
        boolean allDivByTen = numbers.stream()
                .allMatch(num -> num % 10 ==0);
        System.out.println("Все ли числа делятся на 10 без остатка? - " + allDivByTen);

        //Имеется коллекция строк. При помощи stream api необходимо
        Collection<String> words = Arrays.asList("pure", "hands", "etc", "qwerty", "elephant");
        //1) получить коллекцию чисел, каждой число которого - длинна строки исходной коллекции
        List<Integer> len  = words.stream()
                .map(String::length)
                .toList();
        System.out.println(len);

        //2) получить коллекцию строк где все элементы приведены к верхнему регистру
        List<String> upperCase = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCase);

        //3) получить коллекцию строк, в которой нет элементов с буквой "a"
        List<String> wordsWithoutA = words.stream()
                .filter(str -> !str.contains("a"))
                .toList();
        System.out.println(wordsWithoutA);

    }

}
