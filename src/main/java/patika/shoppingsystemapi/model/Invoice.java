package patika.shoppingsystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Invoice {
    private Integer id;
    private LocalDateTime createdDatetime;
    private Double amount;
}
