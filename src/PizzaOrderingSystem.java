import java.util.Date;
import java.util.Scanner;

public class PizzaOrderingSystem {
    public static int countPizza = 1, customerId = 1;
    public static PizzaStore pizzaStore = new PizzaStore("loc", "nameOfStore", 1);
    public static PizzaService pizzaService = new PizzaService(pizzaStore);

    public static void main(String[] args) throws PizzaNotFoundException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose your role to login: ");
            System.out.println("1-admin" + "\n" + "2-customer");
            int num = 0;
            try {
                num = in.nextInt();
            }
            catch (Exception e){
                System.out.println(e);
                break;
            }

            if (num == 1) {
                while (true) {
                    System.out.println("1-add Pizza" + "\n" + "2-update Price" + "\n" + "3-delete Pizza" + "\n" + "4-view all Pizza" + "\n" + "5-search pizza" + "\n" + "6-exit");
                    int n = 0;
                    try {
                                n = in.nextInt();
                    }
                    catch (Exception e){
                        System.out.println(e);
                        break;
                    }


                    if (n == 1) {
                        Pizza pizza = new Pizza();

                        System.out.println("add new pizza menu");
                        System.out.println("enter details for topping as name, spice level, description");
                        String toppingDetailsName = in.next();
                        String toppingDetailsSpice = in.next();
                        String toppingDetailsDescription = in.next();
                        Topping topping = new Topping(toppingDetailsDescription.replace(",", ""), toppingDetailsSpice.replace(",", ""), toppingDetailsName.replace(",", ""));
                        System.out.println("enter details as name of Base, type, description");
                        String baseDetailName = in.next();
                        String baseDetailType = in.next();
                        String baseDetailDescription = in.next();
                        PizzaBase pizzaBase = new PizzaBase(baseDetailDescription.replace(",", ""), baseDetailType.replace(",", ""), baseDetailName.replace(",", ""));
                        System.out.println("enter details as name of Pizza, price, size");
                        String pizzaDetailName = in.next();
                        String pizzaDetailPrice = in.next();
                        String pizzaDetailSize = in.next();

                        pizza.setPizzaBase(pizzaBase);
                        pizza.setPizzaId(countPizza++);
                        pizza.setPizzaName(pizzaDetailName.replace(",", ""));
                        pizza.setSize(pizzaDetailSize);
                        pizza.setPrice(Double.parseDouble(pizzaDetailPrice.replace(",", "")));
                        pizza.setTopping(topping);
                        pizzaStore.addPizza(pizza);
                        System.out.println(pizza);
                    } else if (n == 2) {
                        System.out.println("update pizza menu");
                        System.out.println("enter pizza name: ");
                        String pizzaName = in.next();
                        System.out.println("enter new price: ");
                        double newPrice = in.nextDouble();
                        try {
                            pizzaService.updatePrice(pizzaName, newPrice);
                            System.out.println("Price updated successfully!");

                        } catch (PizzaNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (n == 3) {
                        System.out.println("enter pizza name: ");
                        String pizzaName = in.next();
                        try {
                            pizzaService.deletePizza(pizzaService.getPizzaByName(pizzaName));
                            System.out.println("pizza deleted successfully!");

                        } catch (PizzaNotFoundException e) {
                            System.out.println(e);
                        }
                    } else if (n == 4) {
                        System.out.println(pizzaStore.getPizzas());
                    } else if (n == 5) {
                        System.out.println("choose your search type" + "\n" + "1-By name" + "\n" + "2-By id" + "\n" + "3-By Size");
                        int searchType = in.nextInt();
                        if (searchType == 1) {
                            System.out.println("enter Pizza name to search");
                            String searchName = in.next();
                            try {
                                System.out.println(pizzaService.getPizzaByName(searchName));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        } else if (searchType == 2) {
                            System.out.println("enter Pizza id to search");
                            int searchId = in.nextInt();
                            try {
                                System.out.println(pizzaService.getPizzaById(searchId));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        } else if (searchType == 3) {
                            System.out.println("enter Pizza size to search");
                            String searchSize = in.next();
                            try {
                                System.out.println(pizzaService.getPizzaBySize(searchSize));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        }
                    } else if (n == 6) {
                        System.out.println("thank you admin");
                        break; // Exit the loop
                    } else {
                        System.out.println("invalid option, try again");
                    }
                }
            }
            if (num == 2) {
                System.out.println("welcome to CUSTOMER console !!!");
                System.out.println("enter your doorNumber, street, city, district, state...");
                int doorNumber = Integer.parseInt(in.next().replace(",", ""));
                String street = in.next();
                String city = in.next();
                String district = in.next();
                String state = in.next();
                Address address = new Address(state.replace(",", ""), district.replace(",", ""), city.replace(",", ""), street.replace(",", ""), doorNumber);
                System.out.println("enter your detail as name, email, mobile...");
                String name = in.next().replace(",", "");
                String email = in.next().replace(",", "");
                long mobile = Long.parseLong(in.next().replace(",", ""));
                Customer customer = new Customer(address, mobile, email, name, customerId++);
                System.out.println(customer);
                int  orderId = 1;
                while (true) {
                    System.out.println("choose an option" + "\n" + "1-order pizza" + "\n" + "2-pay bill" + "\n" + "3-view all pizza" + "\n" + "4-view your orders" + "\n" + "5-search pizza" + "\n" + "6-exit");
                    int option = 0;
                    try {
                        option = in.nextInt();
                    }
                    catch (Exception e){
                        System.out.println(e);
                        break;

                    }
                    if (option == 1) {
                        System.out.println("order new pizza menu: ");
                        System.out.println("available pizzas: " + "\n" + pizzaService.getAllPizzas());
                        System.out.println("enter pizza name to place your order (or type 'exit' to finish ordering): ");

                        Order order = new Order();
                        String pizzaName;

                        while (true) {
                             pizzaName = in.next();
                            if (pizzaName.equalsIgnoreCase("exit")) {
                                break; // Exit the ordering loop
                            }

                            try {
                                Pizza pizza = pizzaService.getPizzaByName(pizzaName);
                                order.addPizza(pizza); // Add the pizza to the order
                                System.out.println("Pizza '" + pizzaName + "' added to your order!");
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        order.setPayableBillAmount(order.getTotalAmount());
                        order.setOrderDate(String.valueOf(new Date()));
                        order.setOrderDescription("desc");
                        order.setOrderId(orderId++);
                        customer.addOrder(order);

                        System.out.println("Your order has been successfully placed !!!");
                        System.out.println(order);
                    }

                    else if(option == 2){
                        System.out.println("check your order's bill amount here...");
                        System.out.println("your payable bill amount for all your orders is: "+ customer.getPayableAmount());
                    } else if (option==3) {
                        System.out.println(pizzaService.getAllPizzas());
                    }
                    else if( option == 4){
                        System.out.println(customer.getOrders());

                    } else if (option == 5) {
                        System.out.println("choose your search type" + "\n" + "1-By name" + "\n" + "2-By id" + "\n" + "3-By Size");
                        int searchType = in.nextInt();
                        if (searchType == 1) {
                            System.out.println("enter Pizza name to search");
                            String searchName = in.next();
                            try {
                                System.out.println(pizzaService.getPizzaByName(searchName));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        } else if (searchType == 2) {
                            System.out.println("enter Pizza id to search");
                            int searchId = in.nextInt();
                            try {
                                System.out.println(pizzaService.getPizzaById(searchId));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        } else if (searchType == 3) {
                            System.out.println("enter Pizza size to search");
                            String searchSize = in.next();
                            try {
                                System.out.println(pizzaService.getPizzaBySize(searchSize));
                            } catch (PizzaNotFoundException e) {
                                System.out.println(e);
                            }
                        }
                    } else if (option==6) {
                        System.out.println("thank you customer");
                        break;
                    }
                    else {
                        System.out.println("invalid option, try again");

                    }
                }


            }
        }
    }
}
