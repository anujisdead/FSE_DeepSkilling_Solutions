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
}
