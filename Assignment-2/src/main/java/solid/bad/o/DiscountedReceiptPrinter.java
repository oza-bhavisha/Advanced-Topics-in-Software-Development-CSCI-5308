package solid.bad.o;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents a receipt printer that prints the receipt for an order with discounts applied.
 */
public class DiscountedReceiptPrinter {

    /**
     * Prints the receipt for the order, including order items, discounted prices, and total price.
     *
     * @param orderItems the items in the order
     * @param foodPrices the prices of the food items
     * @param discounts the discounts to be applied to certain items
     */
    public void printReceipt(List<String> orderItems, HashMap<String, Double> foodPrices, HashMap<String, Double> discounts) {
        System.out.println("##################");
        System.out.println("Printing receipt...");
        System.out.println();
        System.out.println("Order items:");
        for (String item : orderItems) {
            double originalPrice = foodPrices.get(item);
            double discount = discounts.getOrDefault(item, 0.0);
            double discountedPrice = originalPrice - discount;

            System.out.println(item + " - Original Price: $" + originalPrice + ", Discounted Price: $" + discountedPrice);
        }
        System.out.println("------------------------------");
        System.out.println("Total price is CAD " + calculateTotalPrice(orderItems, foodPrices, discounts));
        System.out.println("------------------------------");
    }

    /**
     * Calculates the total price of the order based on the item prices and discounts.
     *
     * @param orderItems  the items in the order
     * @param foodPrices  the prices of the food items
     * @param discounts   the discounts to be applied to certain items
     * @return the total price of the order
     */
    private double calculateTotalPrice(List<String> orderItems, HashMap<String, Double> foodPrices, HashMap<String, Double> discounts) {
        double totalPrice = 0;
        for (String item : orderItems) {
            double originalPrice = foodPrices.get(item);
            double discount = discounts.getOrDefault(item, 0.0);
            double discountedPrice = originalPrice - discount;

            totalPrice += discountedPrice;
        }
        return totalPrice;
    }

    /**
     * Prints the receipt for the order, including order items and total price.
     * This method is used when no discounts are provided.
     *
     * @param orderItems  the items in the order
     * @param foodPrices  the prices of the food items
     */
    public void printReceipt(List<String> orderItems, HashMap<String, Double> foodPrices) {
        printReceipt(orderItems, foodPrices, new HashMap<>());
    }
}