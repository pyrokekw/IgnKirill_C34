package interfaces.impls;

import domain.User;
import interfaces.DeliveryService;

public class DeliveryHomeImpl implements DeliveryService {

    @Override
    public void deliveryOrder(User user) {
        System.out.println("Заказ был доставлен до дома пользователя " + user.getLogin());
    }
}
