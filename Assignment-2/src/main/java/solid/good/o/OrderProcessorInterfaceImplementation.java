package solid.good.o;

import java.util.List;

/**
 * This class represents a concrete implementation of the OrderProcessor interface.
 */
public class OrderProcessorInterfaceImplementation implements OrderProcessor {

    /**
     * Prepares, cooks, and serves the orders by printing the corresponding steps for each item.
     *
     * @param orderItems the items to process
     */
    @Override
    public void process(List<String> orderItems) {
        System.out.println("##################");
        System.out.println("Processing order...");
        System.out.println();
        prepare(orderItems);
        cook(orderItems);
        serve(orderItems);
    }

    private void prepare(List<String> orderItems) {
        System.out.println("Preparing order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Preparing " + item);
            System.out.println();
        }
    }

    private void cook(List<String> orderItems) {
        System.out.println("Cooking order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Cooking " + item);
            System.out.println();
        }
    }

    private void serve(List<String> orderItems) {
        System.out.println("Serving order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Serving " + item);
            System.out.println();
        }
    }
}