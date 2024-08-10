package patika.shoppingsystemapi.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Short stock;
}
