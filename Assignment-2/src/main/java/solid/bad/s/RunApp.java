package solid.bad.s;

import java.util.Arrays;
import java.util.List;

// Main method to run
public class RunApp {
        public static void main(String[] args) {

            // Create an instance of SRPViolation class
            SRPViolation restaurant = new SRPViolation();

            // Define order lists
            List<String> order1 = Arrays.asList("Sandwich","Burger", "Fries", "Pizza", "Dal", "Manchurian");
            List<String> order2 = Arrays.asList("Samosa", "Garlic Bread", "Naan", "Chicken Biryani", "Mango Lassi", "Jalebi", "Fafda");

            // Set food prices
            restaurant.setPrices();

            // Adding orders to the restaurant
            restaurant.addOrder(order1);

            // Remove order
            restaurant.removeOrder();

            // Again add the order
            restaurant.addOrder(order2);

            // Processing orders
            restaurant.processOrders();

            // Printing receipts
            restaurant.printReceipt();

            // Calculating total sales
            restaurant.calculateTotalSales();

            // Calculate total price
            restaurant.calculateTotalPrice();
        }
}