package product;

import enumeration.ProductCategory;

public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    // Getters and setters
    public String getSku() {
        return sku;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void addStock(int quantity) {
        this.quantity=this.quantity+quantity;
    }

    public void removeStock(int quantity) {
        this.quantity=this.quantity-quantity;
    }
}