package patika.shoppingsystemapi.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.shoppingsystemapi.model.Invoice;
import patika.shoppingsystemapi.model.dto.request.InvoiceSaveRequest;
import patika.shoppingsystemapi.model.dto.response.InvoiceResponse;
import patika.shoppingsystemapi.repository.concretes.InvoiceRepository;
import patika.shoppingsystemapi.service.abstracts.InvoiceService;
import patika.shoppingsystemapi.utils.converter.InvoiceConverter;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private Integer invoiceId = 0;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * Saves an invoice record and saves the invoice. Returns the saved invoice along with a success message.
     *
     * @param request A {@link InvoiceSaveRequest} object containing the invoice's details
     * @return A {@link InvoiceResponse} object representing the saved invoice
     */
    @Override
    public InvoiceResponse save(InvoiceSaveRequest request) {
        Invoice invoice = InvoiceConverter.toInvoice(request);
        invoice.setId(++invoiceId);

        invoiceRepository.save(invoice);
        return InvoiceConverter.toResponse(invoice);
    }

    /**
     * Retrieves all invoices and converts them to a list of {@link InvoiceResponse} objects.
     *
     * @return A list of {@link InvoiceResponse} objects representing all invoices
     */
    @Override
    public List<InvoiceResponse> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return InvoiceConverter.toResponse(invoices);
    }

    /**
     * Finds an invoice by its ID and returns it as a {@link InvoiceResponse} object.
     *
     * @param invoiceId The ID of the invoice to find
     * @return The found invoice as a {@link InvoiceResponse} object, or null if not found
     */
    @Override
    public InvoiceResponse findById(int invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findAll()
                .stream()
                .filter(i -> i.getId().equals(invoiceId))
                .findFirst();

        return invoice.map(InvoiceConverter::toResponse).orElse(null);
    }

    /**
     * Finds all invoices with an amount greater than the specified value and converts them to a list of {@link InvoiceResponse} objects.
     *
     * @param amount The minimum amount threshold for filtering invoices
     * @return A list of {@link InvoiceResponse} objects representing invoices above the specified amount
     */
    public List<InvoiceResponse> findUpperAmount(double amount) {
        List<Invoice> invoices = invoiceRepository.findAll().stream()
                .filter(i -> i.getAmount() > amount)
                .toList();

        return InvoiceConverter.toResponse(invoices);
    }
}
