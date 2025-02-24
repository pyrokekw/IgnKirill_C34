package interfaces;

import domain.User;

public interface DeliveryService {

   default void deliveryWindow(User user) {
       System.out.println("Пользователь " + user.getLogin() + " забрал заказ: " + user.getOrder() + " из окна");
   }

   void deliveryOrder(User user);
}
