package interfaces.impls;

import domain.User;
import interfaces.CookingService;

public class CookingServiceImpl implements CookingService {
    @Override
    public void startCooking(User user) {
        System.out.println("Готовится заказ: " + user.getOrder() + " Пользователя " + user.getLogin());
    }
}
