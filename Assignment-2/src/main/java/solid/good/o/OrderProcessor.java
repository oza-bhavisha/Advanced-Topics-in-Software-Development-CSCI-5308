package solid.good.o;

import java.util.List;

/**
 * This interface represents an order processor that prepares, cooks, and serves orders.
 */
public interface OrderProcessor {
    void process(List<String> orderItems);
}