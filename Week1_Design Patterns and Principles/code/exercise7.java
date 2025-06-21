package code;

import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

interface Observer {
    void update();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    public void register(Observer o) {
        observers.add(o);
    }
    public void deregister(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : observers) o.update();
    }
}

class MobileApp implements Observer {
    public void update() {
        System.out.println("MobileApp: Stock updated");
    }
}

class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer app = new MobileApp();
        market.register(app);
        market.notifyObservers();
    }
}