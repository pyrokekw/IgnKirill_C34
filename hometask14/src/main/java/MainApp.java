import task2.Order;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        //1) Необходимо создать числовой список. Из данного списка необходимо получить
        // новый, который будет содержать только четные числа.

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,22,30);
        List<Integer> evenNum = new ArrayList<>();

        for (int num: numbers) {
            if(num % 2 == 0) {
                evenNum.add(num);
            }
        }

        System.out.println(evenNum);

        //2) Создайте объект - заказ (поля - идентификатор, название, статус). Добавьте несколько заказов в set.
        // Создайте еще один заказ,
        // который эквивалентный одному из существующих. Добавьте его к set. Проверьте что добавления не произошло.

        Set<Order> orders = new HashSet<>();
        orders.add(new Order(1,"Ord", "Complete"));
        orders.add(new Order(2,"SecOrd", "Wait"));

        // добавим похожий элемент
        orders.add(new Order(1,"Ord", "Compl"));

        System.out.println(orders);

    }

}
