package interfaces.impls;

import domain.User;
import interfaces.SaveOrder;

public class DatabaseSaved implements SaveOrder {
    @Override
    public void isSaved() {
        System.out.println("Заказ сохранен в базу данных");
    }
}
