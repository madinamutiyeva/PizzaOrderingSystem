import java.util.ArrayList;
import java.util.List;

public class PizzaStore {
    private List<Customer> customers;
    private List<Pizza> pizzas;
    private String storeLocation;
    private String storeName;
    private int storeId;

    public PizzaStore(){}

    public PizzaStore(String storeLocation, String storeName, int storeId) {
        this.pizzas = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.storeId = storeId;
    }
    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void deletePizza(Pizza pizza){
        pizzas.remove(pizza);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

}
