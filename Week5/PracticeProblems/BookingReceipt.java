import java.util.Arrays;

public final class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {

        this.bookingId = bookingId;

        // Defensive copy
        this.seatNumbers = Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {

        // Defensive copy again
        return Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    // "Wither" method
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {

        String[] newSeats = getSeatNumbers();

        newSeats[index] = newSeat;

        return new BookingReceipt(
            bookingId,
            newSeats
        );
    }

    public static void main(String[] args) {

        BookingReceipt b =
            new BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"}
            );

        String[] seats = b.getSeatNumbers();

        System.out.println(seats[0]);

        BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(
            Arrays.toString(b.getSeatNumbers())
        );

        System.out.println(
            Arrays.toString(updated.getSeatNumbers())
        );

        BookingReceipt[] receipts = {
            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),
            null,
            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"}
            )
        };

        processNightlySettlement(receipts);
    }

    public static void processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullCount++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        System.out.println(
            processed + " processed | " +
            nullCount + " null"
        );

        System.out.println(
            "skipped | " +
            groupCount + " group | " +
            individualCount + " individual"
        );
    }
}


// Group booking receipt
class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}