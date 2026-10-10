interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Credit card payment: " + amount);
    }
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("UPI payment: " + amount);
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        double total = 1500;

        Payment p1 = new CreditCard();
        p1.pay(total);

        Payment p2 = new UPI();
        p2.pay(total);
    }
}