package patika.shoppingsystemapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductSaveRequest {
    private String name;
    private String category;
    private Double price;
    private Short stock;
}