package interfaces.impls;

import com.sun.jdi.ObjectReference;
import domain.User;
import interfaces.ReceiptOrder;

public class OnlineReceiptOrder implements ReceiptOrder {
    @Override
    public void order(User user) {
        System.out.println("Вам заказ онлайн:" + user.getOrder());
    }
}
