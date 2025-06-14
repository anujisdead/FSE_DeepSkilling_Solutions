interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        notifier.send();
        System.out.println("Sending SMS Notification");
    }
}

class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifierDecorator(new EmailNotifier());
        notifier.send();
    }
}