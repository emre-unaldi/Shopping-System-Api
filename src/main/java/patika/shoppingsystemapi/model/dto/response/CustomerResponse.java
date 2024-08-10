package patika.shoppingsystemapi.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import patika.shoppingsystemapi.model.Order;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private Short age;
    private String email;
    private String password;
    private List<Order> orders;
}