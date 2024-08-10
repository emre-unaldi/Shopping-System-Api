package patika.shoppingsystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private Integer id;
    private Integer customerId;
    private Integer invoiceId;
    private List<Product> products;
}
