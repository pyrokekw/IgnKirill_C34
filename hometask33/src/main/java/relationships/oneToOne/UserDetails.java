package relationships.oneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    private UUID id;
    private String mobileNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public UserDetails(String mobileNumber, User user) {
        this.mobileNumber = mobileNumber;
        this.user = user;
    }

    @Override
    public String toString() {
        return "mobileNumber='" + mobileNumber;
    }
}
