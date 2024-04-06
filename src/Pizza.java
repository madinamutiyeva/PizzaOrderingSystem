import java.util.ArrayList;
import java.util.List;

public class Pizza  {
   private PizzaBase pizzaBase;
   private Topping topping;
    private String size;
    private double price;
    private String pizzaName;
    private int pizzaId;
    public Pizza(){}

    public Pizza(PizzaBase pizzaBase, Topping topping, String size, double price, String pizzaName, int pizzaId) {
        this.pizzaBase = pizzaBase;
        this.topping = topping;
        this.size = size;
        this.price = price;
        this.pizzaName = pizzaName;
        this.pizzaId = pizzaId;
    }

    public PizzaBase getPizzaBase() {
        return pizzaBase;
    }

    public void setPizzaBase(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaBase=" + pizzaBase +
                ", topping=" + topping +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", pizzaName='" + pizzaName + '\'' +
                ", pizzaId=" + pizzaId +
                '}';
    }


    // Геттеры и сеттеры для доступа к атрибутам
}