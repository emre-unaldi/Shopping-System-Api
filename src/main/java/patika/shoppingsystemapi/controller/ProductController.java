package patika.shoppingsystemapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.shoppingsystemapi.model.dto.request.ProductSaveRequest;
import patika.shoppingsystemapi.model.dto.response.GenericResponse;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;
import patika.shoppingsystemapi.service.abstracts.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<GenericResponse<ProductResponse>> save(@RequestBody ProductSaveRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GenericResponse.success(productService.save(request)));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GenericResponse<ProductResponse>> findById(@PathVariable Integer productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(productService.findById(productId)));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<ProductResponse>>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(productService.findAll()));
    }
}
