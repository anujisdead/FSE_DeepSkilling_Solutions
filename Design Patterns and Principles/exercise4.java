interface PaymentProcessor {
    void processPayment();
}

class GatewayA {
    void makePayment() {
        System.out.println("Payment made via GatewayA");
    }
}

class GatewayAAdapter implements PaymentProcessor {
    private GatewayA gateway;
    GatewayAAdapter(GatewayA gateway) {
        this.gateway = gateway;
    }
    public void processPayment() {
        gateway.makePayment();
    }
}

class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new GatewayAAdapter(new GatewayA());
        processor.processPayment();
    }
}
