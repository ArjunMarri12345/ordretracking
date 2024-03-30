package springboot.orderstrackingsystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @CreationTimestamp
    private LocalDate orderDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    @JsonIgnore
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItems> orderItems;

    private String status;
    @CurrentTimestamp
    private LocalDate deliveryDate;

    public Orders(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Orders(int orderId, LocalDate orderDate, Customer customer, String status, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    public Orders() {
    }

    public List<OrderItems> getOrderItems() {
        return this.orderItems;
    }

    public List<Integer> getOrderItemIds() {
        List<Integer> orderItemIds = new ArrayList<>();
        if (getOrderItems() != null) {
            for (OrderItems orderItem : getOrderItems()) {
                orderItemIds.add(orderItem.getId());

            }
        }

        return orderItemIds;
    }

    public Orders(Customer customer, List<OrderItems> orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Orders(LocalDate orderDate, Customer customer, List<OrderItems> orderItems, String status,
            LocalDate deliveryDate) {

        this.orderDate = orderDate;
        this.customer = customer;
        this.orderItems = orderItems;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "{" +
                " orderId='" + getOrderId() + "'" +
                ", orderDate='" + getOrderDate() + "'" +
                ", customerId='" + getCustomer().getCustomerId() + "'" +
                ", orderItemIds='" + getOrderItemIds() + "'" +
                ", status='" + getStatus() + "'" +
                ", deliveryDate='" + getDeliveryDate() + "'" +
                "}";
    }

}
