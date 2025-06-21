package code;
import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();

    void addProduct(Product p) {
        products.put(p.productId, p);
    }

    void updateProduct(int id, Product newProduct) {
        products.put(id, newProduct);
    }

    void deleteProduct(int id) {
        products.remove(id);
    }

    void displayProducts() {
        for (Product p : products.values()) {
            System.out.println("ID: " + p.productId + ", Name: " + p.productName + ", Qty: " + p.quantity + ", Price: " + p.price);
        }
    }
}

class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product(1, "Laptop", 10, 1200.50);
        Product p2 = new Product(2, "Mouse", 50, 25.00);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        System.out.println("Inventory after adding products:");
        inventory.displayProducts();

        Product updatedP1 = new Product(1, "Gaming Laptop", 8, 1500.75);
        inventory.updateProduct(1, updatedP1);

        System.out.println("\nInventory after updating a product:");
        inventory.displayProducts();

        inventory.deleteProduct(2);

        System.out.println("\nInventory after deleting a product:");
        inventory.displayProducts();
    }
}
