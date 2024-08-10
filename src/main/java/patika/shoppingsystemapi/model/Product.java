package patika.shoppingsystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Short stock;
}
