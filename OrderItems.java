package springboot.orderstrackingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;

    @SuppressWarnings("unused")
    private double price;

    public OrderItems(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        double sum = 0.0;
        for (int i = 0; i < getQuantity(); i++) {
            sum += this.getProduct().getProductPrice();
        }
        return sum;
    }

    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderItems() {
    }

    public OrderItems(Orders orders, Product product, int quantity) {

        this.orders = orders;
        this.product = product;
        this.quantity = quantity;

    }

    public OrderItems(int id, Orders orders, Product product, int quantity) {
        this.id = id;
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", ordersIds='" + getOrders().getOrderId() + "'" +
                ", productIds='" + getProduct().getProductId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
