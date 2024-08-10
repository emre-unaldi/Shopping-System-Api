package patika.shoppingsystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Short age;
    private String email;
    private String password;
    private List<Order> orders;
}
