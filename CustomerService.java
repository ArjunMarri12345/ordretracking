package springboot.orderstrackingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.orderstrackingsystem.model.Customer;
import springboot.orderstrackingsystem.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

}