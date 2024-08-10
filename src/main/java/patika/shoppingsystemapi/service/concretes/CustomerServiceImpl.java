package patika.shoppingsystemapi.service.concretes;

import org.springframework.stereotype.Service;
import patika.shoppingsystemapi.model.Customer;
import patika.shoppingsystemapi.model.Order;
import patika.shoppingsystemapi.model.Product;
import patika.shoppingsystemapi.model.dto.request.CustomerSaveRequest;
import patika.shoppingsystemapi.model.dto.response.CustomerResponse;
import patika.shoppingsystemapi.model.dto.response.OrderResponse;
import patika.shoppingsystemapi.repository.concretes.CustomerRepository;
import patika.shoppingsystemapi.service.abstracts.CustomerService;
import patika.shoppingsystemapi.service.abstracts.OrderService;
import patika.shoppingsystemapi.utils.converter.CustomerConverter;
import patika.shoppingsystemapi.utils.converter.OrderConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private Integer customerId = 0;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    /**
     * Saves a customer record, associates it with orders, and saves the customer. Returns the saved customer along with a success message.
     *
     * @param request A {@link CustomerSaveRequest} object containing the customer's details
     * @return A {@link CustomerResponse} object representing the saved customer
     */
    @Override
    public CustomerResponse save(CustomerSaveRequest request) {
        Customer customer = CustomerConverter.toCustomer(request);
        customer.setId(++customerId);

        List<OrderResponse> orderResponses = orderService.findAll().stream()
                .filter(o -> request.getOrderIds().contains(o.getId()))
                .toList();

        List<Order> orders = OrderConverter.toOrder(orderResponses);

        orders.forEach(System.out::println);

        if (orders.isEmpty()) {
            customer.setOrders(new ArrayList<>());
        } else {
            customer.setOrders(orders);
        }

        customerRepository.save(customer);

        return CustomerConverter.toResponse(customer);
    }

    /**
     * Retrieves all customers and converts them to a list of {@link CustomerResponse} objects.
     *
     * @return A list of {@link CustomerResponse} objects representing all customers
     */
    @Override
    public List<CustomerResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerConverter.toResponse(customers);
    }

    /**
     * Finds a customer by their ID and returns them as a {@link CustomerResponse} object.
     *
     * @param customerId The ID of the customer to find
     * @return The found customer as a {@link CustomerResponse} object, or null if not found
     */
    @Override
    public CustomerResponse findById(int customerId) {
        Optional<Customer> customer = customerRepository.findAll().stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst();

        return customer.map(CustomerConverter::toResponse).orElse(null);
    }

    /**
     * Counts the total number of customers in the system.
     *
     * @return The total count of customers
     */
    @Override
    public Integer findTotalCustomerCount(){
        return customerRepository.findAll().size();
    }

    /**
     * Counts the total number of products ordered by customers with a given first name.
     *
     * @param firstName The first name of the customers to filter by
     * @return The total count of products ordered by matching customers
     */
    @Override
    public Long findProductCountByFirstName(String firstName) {
        return customerRepository.findAll().stream()
                .filter(customer -> firstName.equals(customer.getFirstName()))
                .flatMap(customer -> customer.getOrders().stream())
                .mapToLong(order -> order.getProducts().size())
                .sum();
    }

    /**
     * Calculates the total amount of products ordered by customers with a given first name, within a specified age range.
     *
     * @param firstName The first name of the customers to filter by
     * @return The total amount of products ordered by matching customers within the specified age range
     */
    @Override
    public Double findTotalProductAmountByFirstName(String firstName) {
        return customerRepository.findAll().stream()
                .filter(customer -> firstName.equals(customer.getFirstName()))
                .filter(customer -> customer.getAge() < 30 && customer.getAge() > 25)
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }
}