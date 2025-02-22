package interfaces.impls;

import domain.User;
import interfaces.DeliveryService;

public class DeliveryWindowImpl implements DeliveryService {
    @Override
    public void deliveryToHome(User user) {
        deliveryWindow(user);
    }
}
