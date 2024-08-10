package patika.shoppingsystemapi.utils.converter;

import patika.shoppingsystemapi.model.Invoice;
import patika.shoppingsystemapi.model.dto.request.InvoiceSaveRequest;
import patika.shoppingsystemapi.model.dto.response.InvoiceResponse;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceConverter {
    public static Invoice toInvoice(InvoiceSaveRequest request) {
        return Invoice.builder()
                .createdDatetime(request.getCreatedDatetime())
                .amount(request.getAmount())
                .build();
    }

    public static InvoiceResponse toResponse(Invoice invoice) {
        return InvoiceResponse.builder()
                .id(invoice.getId())
                .createdDatetime(invoice.getCreatedDatetime())
                .amount(invoice.getAmount())
                .build();
    }

    public static List<InvoiceResponse> toResponse(List<Invoice> invoices) {
        return invoices
                .stream()
                .map(InvoiceConverter::toResponse)
                .collect(Collectors.toList());
    }
}
