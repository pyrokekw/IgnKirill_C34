package task2;

import java.util.Objects;

public class Order {

    private int id;
    private String name;
    private String status;

    public Order(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order order = (Order)obj;
        return id == order.id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
