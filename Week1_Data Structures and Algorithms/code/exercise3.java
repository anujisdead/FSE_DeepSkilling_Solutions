package code;
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

class SortOrders {
    static void bubbleSort(Order[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

class SortTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.75),
            new Order(2, "Bob", 150.50),
            new Order(3, "Charlie", 300.00),
            new Order(4, "David", 120.25)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        Order[] bubbleSortOrders = java.util.Arrays.copyOf(orders, orders.length);
        SortOrders.bubbleSort(bubbleSortOrders);
        System.out.println("\nOrders after Bubble Sort:");
        printOrders(bubbleSortOrders);

        // Quick Sort
        Order[] quickSortOrders = java.util.Arrays.copyOf(orders, orders.length);
        SortOrders.quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        printOrders(quickSortOrders);
    }

    static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("ID: " + order.orderId + ", Name: " + order.customerName + ", Price: " + order.totalPrice);
        }
    }
}
