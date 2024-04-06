import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Order> orders;
    private Address address;
    private long mobile;
    private String email;
    private String customerName;
    private int customerId;

    public Customer(Address address, long mobile, String email, String customerName, int customerId) {
        this.orders = new ArrayList<>();
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.customerName = customerName;
        this.customerId = customerId;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public double getPayableAmount() {
        double totalAmount = 0.0;

        for (Order order : orders) {
            totalAmount += order.getTotalAmount();
        }

        return totalAmount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "orders=" + orders +
                ", address=" + address +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerId=" + customerId +
                '}';
    }
    // Реализуйте остальные методы интерфейса
}