package patika.shoppingsystemapi.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.shoppingsystemapi.model.Product;
import patika.shoppingsystemapi.model.dto.request.ProductSaveRequest;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;
import patika.shoppingsystemapi.repository.concretes.ProductRepository;
import patika.shoppingsystemapi.service.abstracts.ProductService;
import patika.shoppingsystemapi.utils.converter.ProductConverter;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private Integer productId = 0;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Saves a product record and saves the product. Returns the saved product along with a success message.
     *
     * @param request A {@link ProductSaveRequest} object containing the product's details
     * @return A {@link ProductResponse} object representing the saved product
     */
    @Override
    public ProductResponse save(ProductSaveRequest request) {
        Product product = ProductConverter.toProduct(request);
        product.setId(++productId);
        productRepository.save(product);
        return ProductConverter.toResponse(product);
    }

    /**
     * Retrieves all products and converts them to a list of {@link ProductResponse} objects.
     *
     * @return A list of {@link ProductResponse} objects representing all products
     */
    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return ProductConverter.toResponse(products);
    }

    /**
     * Finds a product by its ID and returns it as a {@link ProductResponse} object.
     *
     * @param productId The ID of the product to find
     * @return The found product as a {@link ProductResponse} object, or null if not found
     */
    @Override
    public ProductResponse findById(int productId) {
        Optional<Product> product = productRepository.findAll()
                .stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst();

        return product.map(ProductConverter::toResponse).orElse(null);
    }
}