class TicketCounter {
    int availableSeats;

    TicketCounter(int seats) {
        availableSeats = seats;
    }

    void bookTickets(String name, int count) {
        if (count <= 0) {
            System.out.println("Invalid ticket count.");
        } else if (count > 6) {
            System.out.println("Maximum 6 tickets per booking.");
        } else if (count <= availableSeats) {
            availableSeats -= count;
            System.out.println(name + " booked " + count + " tickets.");
            System.out.println("Seats remaining: " + availableSeats);
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    void cancelTickets(int count) {
        if (count > 0) {
            availableSeats += count;
            System.out.println(count + " tickets cancelled.");
        }
    }
}

public class CampusTicketCounter {
    public static void main(String[] args) {
        TicketCounter t = new TicketCounter(20);

        t.bookTickets("Asha", 3);
        t.bookTickets("Ravi", 25);
        t.cancelTickets(2);
        t.bookTickets("Neha", 4);
    }
}