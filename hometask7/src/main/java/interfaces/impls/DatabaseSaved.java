package interfaces.impls;

import interfaces.SaveOrder;

public class DatabaseSaved implements SaveOrder {
    @Override
    public void orderSaved() {
        System.out.println("Заказ сохранен в базу данных");
    }
}
