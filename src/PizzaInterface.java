import java.util.List;

public interface PizzaInterface {
    Pizza getPizzaBySize(String size) throws PizzaNotFoundException;
    Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException;
    Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException;
    Pizza orderNewPizza(Pizza pizza, Customer customer);
    List<Pizza> getAllPizzas();
    Pizza updatePrice(Pizza pizza, double newPrice);

    void updatePrice(String pizzaName, double newPrice) throws PizzaNotFoundException;

    void deletePizza(Pizza pizza);
    Pizza addNewPizza(Pizza pizza);
}