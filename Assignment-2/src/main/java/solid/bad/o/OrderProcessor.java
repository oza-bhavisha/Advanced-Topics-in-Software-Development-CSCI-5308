package solid.bad.o;

import java.util.List;

/**
 * This class represents an order processor that prepares, cooks, and serves orders.
 */
public class OrderProcessor {

    /**
     * Prepares the order by printing the preparation steps for each item.
     *
     * @param orderItems the items to prepare
     */
    public void prepare(List<String> orderItems) {
        System.out.println("##################");
        System.out.println("Preparing order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Preparing " + item);
            System.out.println();
        }
    }

    /**
     * Cooks the order by printing the cooking steps for each item.
     *
     * @param orderItems the items to cook
     */
    public void cook(List<String> orderItems) {
        System.out.println("##################");
        System.out.println("Cooking order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Cooking " + item);
            System.out.println();
        }
    }

    /**
     * Serves the order by printing the serving steps for each item.
     *
     * @param orderItems the items to serve
     */
    public void serve(List<String> orderItems) {
        System.out.println("##################");
        System.out.println("Serving order...");
        System.out.println();
        for (String item : orderItems) {
            System.out.println("##################");
            System.out.println("Serving " + item);
            System.out.println();
        }
    }
}