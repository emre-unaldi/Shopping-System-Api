package patika.shoppingsystemapi.service.abstracts;

import patika.shoppingsystemapi.model.dto.request.OrderSaveRequest;
import patika.shoppingsystemapi.model.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse save(OrderSaveRequest request);
    List<OrderResponse> findAll();
    OrderResponse findById(int orderId);
}
