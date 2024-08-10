package patika.shoppingsystemapi.service.abstracts;

import patika.shoppingsystemapi.model.dto.request.ProductSaveRequest;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse save(ProductSaveRequest request);
    List<ProductResponse> findAll();
    ProductResponse findById(int productId);
}
