import product.Product;

public interface ReplenishmentStrategy {
    // Method to replenish stock for a given product
    void replenish(Product product);
}