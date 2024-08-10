package patika.shoppingsystemapi.service.abstracts;

import patika.shoppingsystemapi.model.dto.request.CustomerSaveRequest;
import patika.shoppingsystemapi.model.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(CustomerSaveRequest request);
    List<CustomerResponse> findAll();
    CustomerResponse findById(int customerId);
    Integer findTotalCustomerCount();
    Long findProductCountByFirstName(String firstName);
    Double findTotalProductAmountByFirstName(String firstName);
}
