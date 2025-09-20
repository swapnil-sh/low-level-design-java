import enumeration.ProductCategory;
import product.Product;
import product.ProductFactory;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = InventoryManager.getInstance();

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse(1,"Warehouse 1", "Kolkata");
        Warehouse warehouse2 = new Warehouse(2,"Warehouse 2", "Ahmedabad");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000.0, 50, 25);
        Product tShirt = productFactory.createProduct(
                ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 100);
        Product apple = productFactory.createProduct(
                ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100, 200);

        // Add products to warehouses
        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Switch replenishment strategy to Bulk Order
        inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());

        // Replenish a specific product if needed
        inventoryManager.checkAndReplenish("SKU123");
    }
}

/*

Interview Setting

Point 1: Introduction and Vague Problem Statement:
Interviewer: Let's start with a basic problem statement. Design an Inventory Management System.
Candidate: Certainly! Here's my understanding of the Inventory Management System:
• The system will manage multiple products across different warehouses.
• Users can add, remove, and transfer inventory items.
• The system tracks stock levels and alerts on low inventory.
• Reports can be generated for inventory analysis.
• The system should be scalable to handle businesses of different sizes.
Is this the expected flow?
Interviewer: Yes, you are aligned with the flow. Please continue ahead.
Candidate: Great! Before diving into the design, I'd like to clarify a few requirements:
• What types of products should the system support?
• Are there specific inventory replenishment (restoration of stock) strategies to implement?
• How should the system handle product categorization?


Point 2: Clarifying Requirements :
Interviewer: We want a system that:
• Supports multiple product types in multiple warehouses.
• Handles both inventory additions and removals.
• Efficiently notifies when stock levels are low.


Candidate: To summarize, the key requirements are:

• A system with multiple warehouses and product categories.
• Stock level tracking and management.
• Intelligent replenishment strategy implementation.
• Ability to handle edge cases like damaged inventory or returns.
Interviewer: Perfect, let's proceed.


Point 3: Identifying Key Components/Entities:
Candidate: Now that we have the requirements, let's identify the key components of our Inventory Management System:
product.Product: Represents individual products in inventory.
• Class: product.Product
• Description: This class represents individual products with their attributes.
* Safety Features:
• Threshold alerts prevent stockouts.
• Audit trails track all inventory changes.
• Access control limits who can perform different inventory operations.

Point 4: Design Challenges:
Interviewer: What design challenges do you anticipate?

‍

Candidate: The key challenges for the Inventory Management System include:

1. Scalability: Handling large numbers of products and warehouses.

2. Concurrency: Managing multiple simultaneous inventory operations.

3. Data Consistency: Ensuring accurate inventory counts across the system.

4. Customizable Replenishment: Supporting different replenishment strategies.

5. Edge Cases: Handling product returns, damaged inventory, and seasonal demand fluctuations.

Interviewer: How would you approach these challenges?

‍

Candidate: I propose using design patterns effectively. Here are my strategies:

1. Singleton Pattern for Inventory Manager:

• Ensures a single point of control for inventory operations.

• Maintains consistency across the system.

2. Observer Pattern for Inventory Alerts:

• Notifies relevant stakeholders when stock falls below thresholds.

• Enables real-time inventory monitoring.



3. Factory Pattern for product.Product Creation:
• Encapsulates product creation logic.
• Allows for easy addition of new product types.


4. Strategy Pattern for Replenishment:
• Enables different replenishment strategies.
• Can switch between algorithms based on product type or season.


5. State Management with Enums:

• To effectively manage product categories and operations, we'll use enums.
* */