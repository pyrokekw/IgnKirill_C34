import classes.Address;
import classes.Type;
import entity.OrderEntity;
import services.OrderService;
import java.time.LocalDate;

public class MainApp {

    private static final OrderService service = new OrderService();

    public static void main(String[] args) {

        OrderEntity order1 = new OrderEntity("nameA",
                Type.FRUIT, LocalDate.now(),
                new Address("Moscow", "Red", 31),
                9000L, true);
        OrderEntity order2 = new OrderEntity("nameB",
                Type.VEGETABLES, LocalDate.now(),
                new Address("Minsk", "Blue", 15),
                15000L, false);
        OrderEntity order3 = new OrderEntity("nameC",
                Type.MEAT, LocalDate.now(),
                new Address("Brest", "Yellow", 2),
                19000L, false);

        OrderEntity savedOrder1 = service.save(order1);

        OrderEntity order = service.findByID(savedOrder1.getId());

        System.out.println("Order "+ order);
    }
}
