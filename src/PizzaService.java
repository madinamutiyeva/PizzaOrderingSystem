import java.util.ArrayList;
import java.util.List;

public class PizzaService implements PizzaInterface {
    String PizzaNotFoundMessage = "Pizza not found";
    PizzaStore pizzaStore;

    PizzaService(PizzaStore pizzaStore) {
        this.pizzaStore = pizzaStore;
    }

    @Override
    public Pizza getPizzaBySize(String size) throws PizzaNotFoundException{
        List<Pizza> pizzas = pizzaStore.getPizzas();
        for (Pizza pizza : pizzas) {
            if (pizza.getSize().equalsIgnoreCase(size)) {
                return pizza;
            }
        }
        throw new PizzaNotFoundException("Pizza not found with size: " + size);
    }

    @Override
    public Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException {
        List<Pizza> pizzas = pizzaStore.getPizzas();
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaId() == pizzaId) {
                return pizza;
            }
        }
        throw new PizzaNotFoundException("Pizza not found with id: " + pizzaId);
    }

    @Override
    public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException {
        List<Pizza> pizzas = pizzaStore.getPizzas();
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaName().equalsIgnoreCase(pizzaName)) {
                return pizza;
            }
        }
        throw new PizzaNotFoundException("Pizza not found with name: " + pizzaName);
    }

    @Override
    public Pizza orderNewPizza(Pizza pizza, Customer customer) {
        // Implement order logic here
        // You might want to update some state or interact with other classes
        // For now, just return the pizza as it is
        return pizza;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaStore.getPizzas();
    }

    @Override
    public Pizza updatePrice(Pizza pizza, double newPrice) {
        pizza.setPrice(newPrice);
        return pizza;
    }

    @Override
    public void updatePrice(String pizzaName, double newPrice) throws PizzaNotFoundException {
        Pizza pizzaToUpdate = getPizzaByName(pizzaName);
        if (pizzaToUpdate != null) {
            updatePrice(pizzaToUpdate, newPrice);
        } else {
            throw new PizzaNotFoundException(PizzaNotFoundMessage);
        }
    }

    @Override
    public void deletePizza(Pizza pizza) {
        pizzaStore.deletePizza(pizza);
    }

    @Override
    public Pizza addNewPizza(Pizza pizza) {
        pizzaStore.addPizza(pizza);
        return pizza;
    }
}
