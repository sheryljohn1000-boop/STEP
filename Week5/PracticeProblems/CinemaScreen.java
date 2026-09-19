class CinemaScreen {

    private final int seatsTotal;
    private int seatsAvailable;

    CinemaScreen(int seatsTotal) {

        // seatsTotal must be between 1 and 300
        if (seatsTotal <= 0 || seatsTotal > 300) {
            throw new IllegalArgumentException(
                "construction rejected"
            );
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    void cancelBooking() {

        // Cannot exceed the original total
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {

        // Valid screen
        CinemaScreen c = new CinemaScreen(2);

        c.bookSeat();
        c.bookSeat();
        c.bookSeat();

        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();

        System.out.println(c.getSeatsAvailable());

        // Invalid construction
        try {
            CinemaScreen invalid = new CinemaScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
    }
}