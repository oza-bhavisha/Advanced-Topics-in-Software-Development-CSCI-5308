package solid.good.o;

import java.util.List;
import java.util.Map;

/**
 * This interface represents a receipt printer that prints the receipt for an order.
 */
public interface ReceiptPrinter {
    void printReceipt(List<String> orderItems, Map<String, Double> foodPrices);
}