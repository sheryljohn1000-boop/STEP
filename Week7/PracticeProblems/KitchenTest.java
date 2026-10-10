interface Switchable {
    String turnOn();
}

class Fan implements Switchable {
    public String turnOn() {
        return "Fan is on";
    }
}

class Oven implements Switchable {
    public String turnOn() {
        return "Oven is on";
    }
}

public class KitchenTest {
    static void startAll(Switchable[] items) {
        for (Switchable s : items)
            System.out.println(s.turnOn());
    }

    public static void main(String[] args) {
        Switchable[] items = {new Fan(), new Oven()};
        startAll(items);
    }
}