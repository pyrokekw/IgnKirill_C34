package interfaces.impls;

import domain.User;
import interfaces.ReceiptOrder;

public class PhoneReceiptOrder implements ReceiptOrder {

    @Override
    public void order(User user) {
        System.out.println("Вам телефонный заказ: " + user.getOrder());
    }
}
