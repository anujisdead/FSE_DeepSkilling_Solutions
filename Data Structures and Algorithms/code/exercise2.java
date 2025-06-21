package code;
class ProductSearch {
    int productId;
    String productName;
    String category;

    ProductSearch(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

class Search {
    static int linearSearch(ProductSearch[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productName.equals(name)) return i;
        }
        return -1;
    }

    static int binarySearch(ProductSearch[] arr, String name) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = arr[mid].productName.compareTo(name);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

class SearchTest {
    public static void main(String[] args) {
        ProductSearch[] products = {
            new ProductSearch(1, "Apple", "Fruit"),
            new ProductSearch(2, "Banana", "Fruit"),
            new ProductSearch(3, "Carrot", "Vegetable"),
            new ProductSearch(4, "Date", "Fruit"),
            new ProductSearch(5, "Grape", "Fruit")
        };

        // Linear Search
        System.out.println("Linear Search for 'Carrot':");
        int linearResult = Search.linearSearch(products, "Carrot");
        if (linearResult != -1) {
            System.out.println("Found at index: " + linearResult);
        } else {
            System.out.println("Not found.");
        }

        // Binary Search
        System.out.println("\nBinary Search for 'Date':");
        int binaryResult = Search.binarySearch(products, "Date");
        if (binaryResult != -1) {
            System.out.println("Found at index: " + binaryResult);
        } else {
            System.out.println("Not found.");
        }
    }
}
