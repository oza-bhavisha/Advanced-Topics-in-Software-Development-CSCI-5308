package solid.good.s;

import java.util.Arrays;
import java.util.List;

// Main method to run
public class RunApp {
    public static void main(String[] args) {

        FoodMenu restaurant = new FoodMenu();

        // Define order lists
        List<String> order1 = Arrays.asList("Sandwich", "Burger", "Fries", "Pizza", "Dal", "Manchurian");
        List<String> order2 = Arrays.asList("Samosa", "Garlic Bread", "Naan", "Chicken Biryani", "Mango Lassi", "Jalebi", "Fafda");

        // Adding orders to the restaurant
        restaurant.addOrder(order1);

        // Remove order
        restaurant.removeOrder();

        // Again add the order
        restaurant.addOrder(order2);

        OrderProcessor orderProcessor = new OrderProcessor();

        // Process orders
        restaurant.processOrders(orderProcessor);

        ReceiptPrinter receiptPrinter = new ReceiptPrinter();

        // Print receipts
        restaurant.printReceipt(receiptPrinter);

        double totalPrice = restaurant.calculateTotalPrice();
        System.out.println("Total Price: CAD " + totalPrice);
    }
}