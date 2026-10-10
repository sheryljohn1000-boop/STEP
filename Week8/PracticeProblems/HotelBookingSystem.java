class Room {
    int roomNumber;
    double price;
    boolean available = true;

    Room(int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    void book(String customer, int days) {
        if (available) {
            available = false;
            System.out.println("Room booked by " + customer);
            System.out.println("Total price: " + (price * days));
        } else {
            System.out.println("Room is unavailable.");
        }
    }

    void cancel() {
        available = true;
        System.out.println("Booking cancelled.");
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Room r1 = new Room(101, 1000);

        r1.book("Asha", 3);
        r1.book("Ravi", 2);
        r1.cancel();
        r1.book("Ravi", 2);
    }
}