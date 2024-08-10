package patika.shoppingsystemapi.utils.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import patika.shoppingsystemapi.model.Product;
import patika.shoppingsystemapi.model.dto.request.ProductSaveRequest;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConverter {
    public static Product toProduct(ProductSaveRequest request) {
        return Product.builder()
                .name(request.getName())
                .category(request.getCategory())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public static List<ProductResponse> toResponse(List<Product> products) {
        return products
                .stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toList());
    }

    public static List<Product> toProduct(List<ProductResponse> responses) {
        return responses
                .stream()
                .map(response -> Product.builder()
                        .id(response.getId())
                        .name(response.getName())
                        .category(response.getCategory())
                        .price(response.getPrice())
                        .stock(response.getStock())
                        .build())
                .collect(Collectors.toList());
    }

}
