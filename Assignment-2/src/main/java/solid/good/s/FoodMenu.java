package solid.good.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a food menu in the restaurant.
 */
public class FoodMenu {
    private final HashMap<String, Double> foodPrices;
    private final List<String> orderItems;

    // Constructs a new instance of the FoodMenu class.
    public FoodMenu() {
        foodPrices = new HashMap<>();
        orderItems = new ArrayList<>();
        setPrices();
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

    /**
     * Processes the orders by performing preparation, cooking, and serving.
     *
     * @param orderProcessor the order processor to handle the processing of orders
     */
    public void processOrders(OrderProcessor orderProcessor) {
        orderProcessor.prepare(orderItems);
        orderProcessor.cook(orderItems);
        orderProcessor.serve(orderItems);
    }

    /**
     * Prints the receipt for the current order.
     *
     * @param receiptPrinter the receipt printer to handle the printing of the receipt
     */
    public void printReceipt(ReceiptPrinter receiptPrinter) {
        receiptPrinter.printReceipt(orderItems, foodPrices);
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
}