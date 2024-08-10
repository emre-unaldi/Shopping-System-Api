package patika.shoppingsystemapi.utils.converter;

import patika.shoppingsystemapi.model.Customer;
import patika.shoppingsystemapi.model.dto.request.CustomerSaveRequest;
import patika.shoppingsystemapi.model.dto.response.CustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerConverter {
    public static Customer toCustomer(CustomerSaveRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .orders(customer.getOrders())
                .build();
    }

    public static List<CustomerResponse> toResponse(List<Customer> customers) {
        return customers
                .stream()
                .map(CustomerConverter::toResponse)
                .collect(Collectors.toList());
    }
}
