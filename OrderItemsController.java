package springboot.orderstrackingsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.orderstrackingsystem.dto.OrderItemsByProductDto;
import springboot.orderstrackingsystem.dto.OrderItemsDto;
import springboot.orderstrackingsystem.model.OrderItems;
import springboot.orderstrackingsystem.service.OrderItemsService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {

    private final OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @GetMapping("/all")
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }

    @PostMapping("/save")
    public OrderItems save(@RequestBody OrderItems orderItems) {
        return orderItemsService.save(orderItems);
    }

    @PostMapping("/saveAll")
    public List<OrderItems> saveAllOrderItems(@RequestBody List<OrderItems> orderItems) {
        return orderItemsService.saveAllOrderItems(orderItems);
    }

    @GetMapping("/orderItemsDto")
    public List<OrderItemsDto> getAllOrdersInGivenOrder() {
        return orderItemsService.getAllOrderItemsInAOrder();
    }
    @GetMapping("/productIds")
    public List<OrderItemsByProductDto> getOrderItemsByGivenProduct(@RequestParam int productId){
        return orderItemsService.getOrderItemsByGivenProduct(productId);

    }
    }
