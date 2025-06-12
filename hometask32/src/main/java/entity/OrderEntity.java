package entity;

import classes.Address;
import classes.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_table")
public class OrderEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(length = 1024)
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Temporal(TemporalType.DATE)
    //C Instant ERROR, поэтому использовал LocalDate
    private LocalDate date;
    @Embedded
    private Address address;
    private Long salary;
    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private Boolean isPriority;

    public OrderEntity(String name, Type type, LocalDate date, Address address, Long salary, Boolean isPriority) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.address = address;
        this.salary = salary;
        this.isPriority = isPriority;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", date=" + date +
                ", address=" + address +
                ", salary=" + salary +
                ", isPriority=" + isPriority;
    }
}
