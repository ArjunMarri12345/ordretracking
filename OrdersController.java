package springboot.orderstrackingsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.orderstrackingsystem.dto.OrdersDto;
import springboot.orderstrackingsystem.model.Orders;
import springboot.orderstrackingsystem.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping("/save")
    public Orders save(@RequestBody Orders orders) {
        return ordersService.save(orders);
    }

    @PostMapping("/saveAll")
    public List<Orders> saveAllOrders(@RequestBody List<Orders> ordersList) {
        return ordersService.saveAllOrders(ordersList);
    }

    @GetMapping("/orderIds")
    public Orders getMethodName(@RequestParam int orderId) {
        return ordersService.getByOrderId(orderId);
    }
    @GetMapping("/customerId")
    public List<Orders> getAllOrdersByCustomerId(@RequestParam int customerId) {
        return ordersService.getAllOrdersByCustomerId(customerId);
    }
      @GetMapping("/orderDate")
    public List<Orders> getAllOrdersAfterOrderDate(@RequestParam LocalDate orderDate) {
    return ordersService.getByOrderDate(orderDate);
    }

    @GetMapping("/status")
    public List<Orders> getAllByStatus(@RequestParam String status) {
    return ordersService.getByStatus(status);
    }

    @PostMapping("/ordersDto")
    public Orders getByOrdersDto(@RequestBody OrdersDto ordersDto)
    {
        return ordersService.getByOrdersDto(ordersDto);
    }

}
