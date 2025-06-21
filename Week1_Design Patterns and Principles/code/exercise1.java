package code;
public class exercise1 {
    private static exercise1 instance;
    private exercise1() {}
    public static exercise1 getInstance() {
        if (instance == null) {
            instance = new exercise1();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

class SingletonTest {
    public static void main(String[] args) {
        exercise1 logger1 = exercise1.getInstance();
        exercise1 logger2 = exercise1.getInstance();
        System.out.println(logger1 == logger2);
    }
}
