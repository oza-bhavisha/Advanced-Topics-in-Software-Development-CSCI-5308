package solid.good.o;

import java.util.List;
import java.util.Map;

/**
 * This class represents a concrete implementation of the ReceiptPrinter interface.
 */
public class ReceiptPrinterInterfaceImplementation implements ReceiptPrinter {

    /**
     * Prints the receipt for the order, including order items and total price.
     *
     * @param orderItems the items in the order
     * @param foodPrices the prices of the food items
     */
    @Override
    public void printReceipt(List<String> orderItems, Map<String, Double> foodPrices) {
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

    private double calculateTotalPrice(List<String> orderItems, Map<String, Double> foodPrices) {
        double totalPrice = 0;
        for (String item : orderItems) {
            totalPrice += foodPrices.get(item);
        }
        return totalPrice;
    }
}