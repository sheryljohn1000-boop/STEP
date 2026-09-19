import java.util.Arrays;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    // Shared class-level state
    private static String branchCode;

    // Static block runs once
    static {
        branchCode = "MAIN-LIBRARY";
    }

    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = Arrays.copyOf(
            bookIds,
            bookIds.length
        );
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {

        // Defensive copy
        return Arrays.copyOf(
            bookIds,
            bookIds.length
        );
    }

    // Wither method
    public LoanReceipt withCorrectedBookId(
            int index, String newId) {

        String[] newBooks = getBookIds();

        newBooks[index] = newId;

        return new LoanReceipt(
            memberId,
            newBooks
        );
    }

    public static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullCount = 0;
        int referenceOnlyCount = 0;
        int regularCount = 0;

        for (LoanReceipt receipt : receipts) {

            // Handle null safely
            if (receipt == null) {
                nullCount++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnlyCount++;
            } else {
                regularCount++;
            }
        }

        return processed
            + " processed | "
            + nullCount
            + " null | "
            + referenceOnlyCount
            + " reference-only | "
            + regularCount
            + " regular";
    }

    public static void main(String[] args) {

        LoanReceipt r = new LoanReceipt(
            "LIB-8841",
            new String[]{"BK-100", "BK-101"}
        );

        String[] ids = r.getBookIds();

        System.out.println(ids[0]);

        // Change the returned array
        ids[0] = "HACKED";

        // Original receipt is still unchanged
        System.out.println(
            r.getBookIds()[0]
        );

        LoanReceipt corrected =
            r.withCorrectedBookId(
                1,
                "BK-102"
            );

        System.out.println(
            Arrays.toString(r.getBookIds())
        );

        System.out.println(
            Arrays.toString(corrected.getBookIds())
        );

        LoanReceipt[] receipts = {

            new ReferenceOnlyLoanReceipt(
                "LIB-9001",
                new String[]{"BK-200"},
                "ROOM-5"
            ),

            null,

            new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-300"}
            )
        };

        System.out.println(
            processNightlyCirculation(receipts)
        );
    }
}


// Reference-only loan receipt
class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);

        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}