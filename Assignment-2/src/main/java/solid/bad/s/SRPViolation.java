package solid.bad.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a violation of the Single Responsibility Principle (SRP).
 * It contains methods for handling orders, preparing, cooking, and serving items, calculating prices, and printing receipts.
 */
public class SRPViolation {
    private String name;
    private double price;
    private final HashMap<String, Double> foodPrices;

    // Constructor of SRPViolation class.
    public SRPViolation() {
        foodPrices = new HashMap<>();
        orderItems = new ArrayList<>();
    }

    // Sets the prices for various food items.
    public void setPrices() {
        foodPrices.put("Sandwich", 10.00);
        foodPrices.put("Burger", 5.00);
        foodPrices.put("Fries", 8.99);
        foodPrices.put("Pizza", 24.99);
        foodPrices.put("Dal", 17.5);
        foodPrices.put("Manchurian", 6.78);
        foodPrices.put("Samosa", 10.00);
        foodPrices.put("Garlic Bread", 4.99);
        foodPrices.put("Naan", 2.99);
        foodPrices.put("Chicken Biryani", 8.99);
        foodPrices.put("Mango Lassi", 8.99);
        foodPrices.put("Jalebi", 8.99);
        foodPrices.put("Fafda", 10.99);

        // Adding a default item for demonstration purposes
        Item("Fafda", 10.99);
    }

    /**
     * Gets the price of an item by its name.
     *
     * @param itemName the name of the item
     * @return the price of the item
     */
    public Double getPrice(String itemName) {

        return foodPrices.get(itemName);
    }

    private final List<String> orderItems;

    /**
     * Adds an order to the list of order items.
     *
     * @param orderItems the list of items to be added to the order
     */
    public void addOrder(List<String> orderItems) {
        this.orderItems.addAll(orderItems);
    }

    // Removes all items from the current order.
    public void removeOrder() {
        this.orderItems.clear();
    }

    // Processes all orders by preparing, cooking, and serving them.
    public void processOrders() {
        prepare();
        cook();
        serve();
    }

    // Prepares the order by performing necessary actions.
    public void prepare() {
        System.out.println("##################");
        System.out.println("Preparing order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Preparing " + item);
            System.out.println();
        }
    }

    // Cooks the order.
    public void cook() {
        System.out.println("##################");
        System.out.println("Cooking order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Cooking " + item);
            System.out.println();
        }
    }

    // Serves the order.
    public void serve() {
        System.out.println("##################");
        System.out.println("Serving order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Serving " + item);
            System.out.println();
        }
    }

    // Prints receipts for the order.
    public void printReceipt() {
        System.out.println("##################");
        System.out.println("Printing receipt...");
        System.out.println();
        System.out.println("Order items:");
        for (String item : orderItems) {
            System.out.println(item + " - $" + getPrice(item));
        }
        System.out.println("------------------------------");
        System.out.println("Total price is CAD " + calculateTotalPrice());
        System.out.println("------------------------------");
    }


    // Calculates and prints the total sales from all orders.
    public void calculateTotalSales() {
        double totalSales = 0;
        for (String item : orderItems) {
            totalSales += calculateTotalPrice();
        }
        System.out.println("Total Sales: $" + totalSales);
    }

    /**
     * Calculates the total price of the current order.
     *
     * @return the totalPrice of the order
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;

        for (String item : orderItems) {
            totalPrice += getPrice(item);
        }
        return totalPrice;
    }

    /**
     * Sets the name and price of an item.
     *
     * @param name  the name of the item
     * @param price the price of the item
     */
    public void Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the item.
     *
     * @return name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return price of the item.
     */
    public double getPrice() {
        return price;
    }
}