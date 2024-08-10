package patika.shoppingsystemapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderSaveRequest {
    private Integer customerId;
    private Integer invoiceId;
    private List<Integer> productIds;
}
