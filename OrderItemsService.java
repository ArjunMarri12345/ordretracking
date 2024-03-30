package springboot.orderstrackingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.orderstrackingsystem.dto.OrderItemsByProductDto;
import springboot.orderstrackingsystem.dto.OrderItemsDto;
import springboot.orderstrackingsystem.model.OrderItems;
import springboot.orderstrackingsystem.model.Product;
import springboot.orderstrackingsystem.repository.OrderItemsRepository;
import springboot.orderstrackingsystem.repository.ProductRepository;

@Service
public class OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository, ProductRepository productRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.productRepository = productRepository;
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }

    public OrderItems save(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    public List<OrderItems> saveAllOrderItems(List<OrderItems> orderItems) {
        return orderItemsRepository.saveAll(orderItems);
    }

    public List<OrderItemsDto> getAllOrderItemsInAOrder() {
        List<OrderItems> orderItems = orderItemsRepository.findAll();
        List<OrderItemsDto> orderItemsDtoList = new ArrayList<>();
        for (OrderItems orderItems2 : orderItems) {
            OrderItemsDto orderItemsDto = new OrderItemsDto(orderItems2.getProduct().getProductName(),
                    orderItems2.getQuantity(), orderItems2.getPrice());
            orderItemsDtoList.add(orderItemsDto);
            

        }
        return orderItemsDtoList;
    }

    public List<OrderItemsByProductDto> getOrderItemsByGivenProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        List<OrderItems> orderItems = orderItemsRepository.findByProduct(product);
        List<OrderItemsByProductDto> orderItemsDtoList = new ArrayList<>();

        for (OrderItems orderItems2 : orderItems) {
            OrderItemsByProductDto orderItemsDto = new OrderItemsByProductDto(product.getProductName(),
                    orderItems2.getOrders().getCustomer().getCustomerName(), orderItems2.getQuantity(),
                    orderItems2.getPrice(), orderItems2.getOrders().getOrderDate());
            orderItemsDtoList.add(orderItemsDto);
        }
        return orderItemsDtoList;
    }

}
