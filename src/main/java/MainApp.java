import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {

    public static void main(String[] args) {
        String str = "Пусть, это, будет, какая-то, строка";
        //1) Вывести длину строки
        System.out.println(str.length());
        //2) Разбить строку по любому разделителю и вывести количество элементов
        String[] substr = str.split(",");
        System.out.println(substr.length);
        //3) получить подстроку с определенной позиции до конца
        String subString = str.substring(5, str.length());
        System.out.println(subString);
        //4) сделать строку которая будет зеркальна текущей
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        System.out.println(builder.toString());
        //5)Создать произвольный шаблон
        //Сделать строку используя данный шаблон (String.format), вставим некоторые значения
        String str2 = "Товар: Ноутбук, Цена: 59999.99 руб., Количество: 2";

        Pattern pattern = Pattern.compile("Товар: (.*?), Цена: ([0-9]+\\.[0-9]{2}) руб\\., Количество: ([0-9]+)");
        Matcher matcher = pattern.matcher(str2);

        System.out.println("Соответствует ли текст шаблону: " + matcher.matches());
    }
}
