package springboot.orderstrackingsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.orderstrackingsystem.dto.OrdersDto;
import springboot.orderstrackingsystem.model.Customer;
import springboot.orderstrackingsystem.model.OrderItems;
import springboot.orderstrackingsystem.model.Orders;
import springboot.orderstrackingsystem.model.Product;
import springboot.orderstrackingsystem.repository.CustomerRepository;
import springboot.orderstrackingsystem.repository.OrderItemsRepository;
import springboot.orderstrackingsystem.repository.OrdersRepository;
import springboot.orderstrackingsystem.repository.ProductRepository;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;


    public OrdersService(OrdersRepository ordersRepository, CustomerRepository customerRepository, OrderItemsRepository orderItemsRepository, ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.productRepository = productRepository;
    }


    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> saveAllOrders(List<Orders> ordersList) {
        return ordersRepository.saveAll(ordersList);
    }

    public Orders getByOrderId(int orderId) {
        return ordersRepository.findById(orderId).orElse(null);
    }

    public List<Orders> getAllOrdersByCustomerId(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return ordersRepository.findByCustomer(customer);
    }

    public List<Orders> getByOrderDate(LocalDate orderDate) {
        return ordersRepository.findByOrderDate(orderDate);
    }

    public List<Orders> getByStatus(String status) {
        return ordersRepository.findOrdersByStatus(status);
    }

    public Orders getByOrdersDto(OrdersDto ordersDto) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (Product product : ordersDto.getProducts()) {
            productRepository.save(product);

            OrderItems orderItems = new OrderItems(product, ordersDto.getQuantity());
            orderItemsList.add(orderItems);
        }
        Customer customer = customerRepository.findById(ordersDto.getCustomerId()).orElse(null);
        Orders orders = new Orders(customer, orderItemsList);
        customerRepository.save(customer);
        ordersRepository.save(orders);
        orderItemsRepository.saveAll(orderItemsList);

        return orders;
    }

    

}
