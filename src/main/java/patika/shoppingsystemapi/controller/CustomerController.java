package patika.shoppingsystemapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.shoppingsystemapi.model.dto.request.CustomerSaveRequest;
import patika.shoppingsystemapi.model.dto.response.CustomerResponse;
import patika.shoppingsystemapi.model.dto.response.GenericResponse;
import patika.shoppingsystemapi.service.abstracts.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<GenericResponse<CustomerResponse>> save(@RequestBody CustomerSaveRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GenericResponse.success(customerService.save(request)));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<GenericResponse<CustomerResponse>> findById(@PathVariable Integer customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(customerService.findById(customerId)));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<CustomerResponse>>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(customerService.findAll()));
    }

    @GetMapping("/total")
    public ResponseEntity<GenericResponse<Integer>> findTotalCustomerCount() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(customerService.findTotalCustomerCount()));
    }

    @GetMapping("/productCount/{firstName}")
    public ResponseEntity<GenericResponse<Long>> findProductCountByFirstName(@PathVariable String firstName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(customerService.findProductCountByFirstName(firstName)));
    }

    @GetMapping("/totalProductAmount/{firstName}")
    public ResponseEntity<GenericResponse<Double>> findTotalProductAmountByFirstName(@PathVariable String firstName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(customerService.findTotalProductAmountByFirstName(firstName)));
    }
}