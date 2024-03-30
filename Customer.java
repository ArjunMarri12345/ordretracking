package springboot.orderstrackingsystem.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String email;
    private long mobile;
    
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Orders> orders;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return this.mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Customer(int customerId, String customerName, String email, long mobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
    }

    public Customer(String customerName, String email, long mobile) {
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
    }

    public Customer() {
    }

    public Customer(String customerName, String email, long mobile, List<Orders> orders) {
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
        this.orders = orders;
    }

    public Customer(int customerId, String customerName, String email, long mobile, List<Orders> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
        this.orders = orders;
    }

    public List<Orders> getOrders() {
        return this.orders;
    }

    public List<Integer> getOrderIds() {
        List<Integer> orderIds = new ArrayList<>();
        if (getOrders() != null) {
            for (Orders orders1 : getOrders()) {
                orderIds.add(orders1.getOrderId());

            }
        }

        return orderIds;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "{" +
                " customerId='" + getCustomerId() + "'" +
                ", customerName='" + getCustomerName() + "'" +
                ", email='" + getEmail() + "'" +
                ", mobile='" + getMobile() + "'" +
                ", orderIds='" + getOrderIds() + "'" +
                "}";
    }

}
