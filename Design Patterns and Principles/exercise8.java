interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid with Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid with PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;
    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    void executePayment() {
        strategy.pay();
    }
}

class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.executePayment();
    }
}