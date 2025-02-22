package interfaces.impls;

import domain.User;
import interfaces.*;

public class CustomerServiceImpl implements CustomerService {

    private ReceiptOrder receiptOrder;
    private SaveOrder saveOrder;
    private CookingService cookingService;
    private DeliveryService deliveryService;

    public CustomerServiceImpl(ReceiptOrder receiptOrder,
                               SaveOrder saveOrder,
                               CookingService cookingService,
                               DeliveryService deliveryService) {
        this.receiptOrder = receiptOrder;
        this.saveOrder = saveOrder;
        this.cookingService = cookingService;
        this.deliveryService = deliveryService;
    }

    @Override
    public void customService(User user) {
        receiptOrder.order(user);
        saveOrder.isSaved();
        cookingService.startCooking(user);
        deliveryService.deliveryToHome(user);
    }
}
