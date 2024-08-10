package patika.shoppingsystemapi.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class InvoiceResponse {
    private Integer id;
    private LocalDateTime createdDatetime;
    private Double amount;
}