package solid.bad.o;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents a receipt printer that prints the receipt for an order.
 */
public class ReceiptPrinter {

    /**
     * Prints the receipt for the order, including order items and total price.
     *
     * @param orderItems  the items in the order
     * @param foodPrices  the prices of the food items
     */
    public void printReceipt(List<String> orderItems, HashMap<String, Double> foodPrices) {
        System.out.println("##################");
        System.out.println("Printing receipt...");
        System.out.println();
        System.out.println("Order items:");
        for (String item : orderItems) {
            System.out.println(item + " - $" + foodPrices.get(item));
        }
        System.out.println("------------------------------");
        System.out.println("Total price is CAD " + calculateTotalPrice(orderItems, foodPrices));
        System.out.println("------------------------------");
    }

    /**
     * Calculates the total price of the order based on the item prices.
     *
     * @param orderItems  the items in the order
     * @param foodPrices  the prices of the food items
     * @return the total price of the order
     */
    private double calculateTotalPrice(List<String> orderItems, HashMap<String, Double> foodPrices) {
        double totalPrice = 0;
        for (String item : orderItems) {
            totalPrice += foodPrices.get(item);
        }
        return totalPrice;
    }
}