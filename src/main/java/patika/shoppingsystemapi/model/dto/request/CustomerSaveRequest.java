package patika.shoppingsystemapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CustomerSaveRequest {
    private String firstName;
    private String lastName;
    private Short age;
    private String email;
    private String password;
    private List<Integer> orderIds;
}