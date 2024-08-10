package patika.shoppingsystemapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.shoppingsystemapi.model.dto.request.InvoiceSaveRequest;
import patika.shoppingsystemapi.model.dto.request.ProductSaveRequest;
import patika.shoppingsystemapi.model.dto.response.GenericResponse;
import patika.shoppingsystemapi.model.dto.response.InvoiceResponse;
import patika.shoppingsystemapi.model.dto.response.ProductResponse;
import patika.shoppingsystemapi.service.abstracts.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoicesController {
    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<GenericResponse<InvoiceResponse>> save(@RequestBody InvoiceSaveRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GenericResponse.success(invoiceService.save(request)));
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<GenericResponse<InvoiceResponse>> findById(@PathVariable Integer invoiceId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(invoiceService.findById(invoiceId)));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<InvoiceResponse>>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(invoiceService.findAll()));
    }

    @GetMapping("/upperAmount/{amount}")
    public ResponseEntity<GenericResponse<List<InvoiceResponse>>> findUpperAmount(@PathVariable Integer amount) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(GenericResponse.success(invoiceService.findUpperAmount(amount)));
    }
}