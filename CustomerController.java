package springboot.orderstrackingsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.orderstrackingsystem.model.Customer;
import springboot.orderstrackingsystem.service.CustomerService;
@CrossOrigin(origins="http://localhost:1096")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PostMapping("/saveAll")
    public List<Customer> saveAllCustomers(@RequestBody List<Customer> customers) {
        return customerService.saveAllCustomers(customers);
    }

    // @GetMapping("/path")
    // @CrossOrigin(origins = "http://localhost:1096", methods = { RequestMethod.GET })
    // public String getMethodName() {
    //     return "tony";
    // }

}
