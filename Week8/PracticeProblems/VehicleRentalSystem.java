abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double rentalCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double rentalCharge(int days) {
        return days * 50.0;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double rentalCharge(int days) {
        return days * 80.0;
    }
}

public class VehicleRentalSystem {
    static void rent(Vehicle v, String customer, int days) {
        if (v.available) {
            v.available = false;
            System.out.println(customer + " rented " + v.name);
            System.out.println("Charge: " + v.rentalCharge(days));
        } else {
            System.out.println(v.name + " is unavailable.");
        }
    }

    static void returnVehicle(Vehicle v) {
        v.available = true;
        System.out.println(v.name + " returned.");
    }

    public static void main(String[] args) {
        Vehicle v1 = new Sedan("Sedan");
        Vehicle v2 = new SUV("SUV");

        rent(v1, "Asha", 3);
        rent(v1, "Ravi", 2);
        returnVehicle(v1);
        rent(v2, "Neha", 2);
    }
}