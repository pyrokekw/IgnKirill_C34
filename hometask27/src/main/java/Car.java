import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Car {
    private Integer id;
    private String model;
    private Integer salary;

    @Override
    public String toString() {
        return "id=" + id +
                ", model='" + model + '\'' +
                ", salary=" + salary;
    }
}


