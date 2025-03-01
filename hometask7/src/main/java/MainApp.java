import domain.User;
import interfaces.*;
import interfaces.impls.*;

public class MainApp {

    public static void main(String[] args) {
        User user = new User("user123", "password", "Пицца и кола");
        // Здесь телефонный заказ и доставка на дом
        ReceiptOrder receiver = new PhoneReceiptOrder();
        SaveOrder saver = new DatabaseSaved();
        CookingService cookingManager = new CookingServiceImpl();
        DeliveryService delivery = new DeliveryHomeImpl();

        CustomerService customerService = new CustomerServiceImpl(
                receiver, saver, cookingManager, delivery
        );

        customerService.customService(user);

        //

        User user2 = new User("Sanya", "pass", "3 пиццы 10 пива");
        //Онлайн заказ и доставка в окне
        ReceiptOrder receiver2 = new OnlineReceiptOrder();
        SaveOrder saver2 = new DatabaseSaved();
        CookingService cookingManager2 = new CookingServiceImpl();
        DeliveryService delivery2 = new DeliveryWindowImpl();

        CustomerService customerService2 = new CustomerServiceImpl(
                receiver2, saver2, cookingManager2, delivery2
        );

        customerService2.customService(user2);


    }
}