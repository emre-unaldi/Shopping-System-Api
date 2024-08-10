package patika.shoppingsystemapi.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.shoppingsystemapi.model.Order;
import patika.shoppingsystemapi.model.Product;
import patika.shoppingsystemapi.model.dto.request.OrderSaveRequest;
import patika.shoppingsystemapi.model.dto.response.OrderResponse;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;
import patika.shoppingsystemapi.repository.concretes.OrderRepository;
import patika.shoppingsystemapi.service.abstracts.OrderService;
import patika.shoppingsystemapi.service.abstracts.ProductService;
import patika.shoppingsystemapi.utils.converter.OrderConverter;
import patika.shoppingsystemapi.utils.converter.ProductConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private Integer orderId = 0;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    /**
     * Saves an order record, associates it with products, and saves the order. Returns the saved order along with a success message.
     *
     * @param request A {@link OrderSaveRequest} object containing the order's details
     * @return A {@link OrderResponse} object representing the saved order
     */
    @Override
    public OrderResponse save(OrderSaveRequest request) {
        Order order = OrderConverter.toOrder(request);
        order.setId(++orderId);

        List<ProductResponse> productResponses = productService.findAll().stream()
                .filter(p -> request.getProductIds().contains(p.getId()))
                .toList();

        List<Product> products = ProductConverter.toProduct(productResponses);

        if (products.isEmpty()) {
            order.setProducts(new ArrayList<>());
        } else {
            order.setProducts(products);
        }

        orderRepository.save(order);

        return OrderConverter.toResponse(order);
    }

    /**
     * Retrieves all orders and converts them to a list of {@link OrderResponse} objects.
     *
     * @return A list of {@link OrderResponse} objects representing all orders
     */
    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        return OrderConverter.toResponse(orders);
    }

    /**
     * Finds an order by its ID and returns it as a {@link OrderResponse} object.
     *
     * @param orderId The ID of the order to find
     * @return The found order as a {@link OrderResponse} object, or null if not found
     */
    @Override
    public OrderResponse findById(int orderId) {
        Optional<Order> order = orderRepository.findAll().stream()
                .filter(o -> o.getId().equals(orderId))
                .findFirst();

        return order.map(OrderConverter::toResponse).orElse(null);
    }
}
