public class BookInventory {

    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {

        if (copiesTotal <= 0 || copiesTotal > 500) {
            throw new IllegalArgumentException(
                "Invalid number of copies"
            );
        }

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {

        // Only check out if copies are available
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {

        // Only check in if not already at full capacity
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {

        BookInventory b = new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();

        // Fourth checkout is rejected
        b.checkOut();

        System.out.println(
            b.getCopiesAvailable()
        );

        b.checkIn();
        b.checkIn();
        b.checkIn();

        // Fourth check-in is rejected
        b.checkIn();

        System.out.println(
            b.getCopiesAvailable()
        );
    }
}