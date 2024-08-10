package patika.shoppingsystemapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class InvoiceSaveRequest {
    private LocalDateTime createdDatetime;
    private Double amount;
}