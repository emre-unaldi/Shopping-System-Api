package patika.shoppingsystemapi.utils.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import patika.shoppingsystemapi.model.Order;
import patika.shoppingsystemapi.model.dto.request.OrderSaveRequest;
import patika.shoppingsystemapi.model.dto.response.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConverter {
    public static Order toOrder(OrderSaveRequest request) {
        return Order.builder()
                .customerId(request.getCustomerId())
                .invoiceId(request.getInvoiceId())
                .build();
    }

    public static OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .invoiceId(order.getInvoiceId())
                .products(order.getProducts())
                .build();
    }

    public static List<OrderResponse> toResponse(List<Order> orders) {
        return orders
                .stream()
                .map(OrderConverter::toResponse)
                .collect(Collectors.toList());
    }

    public static List<Order> toOrder(List<OrderResponse> responses) {
        return responses
                .stream()
                .map(response -> Order.builder()
                        .id(response.getId())
                        .customerId(response.getCustomerId())
                        .invoiceId(response.getInvoiceId())
                        .products(response.getProducts())
                        .build())
                .collect(Collectors.toList());
    }
}
