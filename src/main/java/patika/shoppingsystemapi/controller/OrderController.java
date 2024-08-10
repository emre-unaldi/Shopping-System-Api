package patika.shoppingsystemapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.shoppingsystemapi.model.dto.request.OrderSaveRequest;
import patika.shoppingsystemapi.model.dto.response.GenericResponse;
import patika.shoppingsystemapi.model.dto.response.OrderResponse;
import patika.shoppingsystemapi.service.abstracts.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<GenericResponse<OrderResponse>> save(@RequestBody OrderSaveRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GenericResponse.success(orderService.save(request)));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<GenericResponse<OrderResponse>> findById(@PathVariable Integer orderId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(orderService.findById(orderId)));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<OrderResponse>>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(orderService.findAll()));
    }
}