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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDesc;
    private double productPrice;
    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItems> orderItems;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productId) {
        this.productId = productId;

    }

    public Product(String productName, String productDesc, double productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public Product(int productId, String productName, String productDesc, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public List<OrderItems> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Product() {
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

    @Override
    public String toString() {
        return "{" +
                " productId='" + getProductId() + "'" +
                ", productName='" + getProductName() + "'" +
                ", productDesc='" + getProductDesc() + "'" +
                ", productPrice='" + getProductPrice() + "'" +
                ", orderItemIds='" + getOrderItemIds() + "'" +
                "}";
    }

}
