package solid.bad.o;

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

        DiscountedReceiptPrinter discountedReceiptPrinter = new DiscountedReceiptPrinter();

        // Print discounted receipts
        discountedReceiptPrinter.printReceipt(restaurant.getOrderItems(), restaurant.getFoodPrices());

        double totalPrice = restaurant.calculateTotalPrice();
        System.out.println("Total Price: CAD " + totalPrice);
    }
}