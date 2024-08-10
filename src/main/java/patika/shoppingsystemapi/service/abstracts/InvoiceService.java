package patika.shoppingsystemapi.service.abstracts;

import patika.shoppingsystemapi.model.dto.request.InvoiceSaveRequest;
import patika.shoppingsystemapi.model.dto.response.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    InvoiceResponse save(InvoiceSaveRequest request);
    List<InvoiceResponse> findAll();
    InvoiceResponse findById(int invoiceId);
    List<InvoiceResponse> findUpperAmount(double amount);
}
