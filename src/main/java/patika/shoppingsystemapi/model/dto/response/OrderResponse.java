package patika.shoppingsystemapi.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import patika.shoppingsystemapi.model.Product;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Integer id;
    private Integer customerId;
    private Integer invoiceId;
    private List<Product> products;
}