class FeeAccount {

    String accountType;

    FeeAccount(String accountType) {
        this.accountType = accountType;
    }

    void processPayment(double amount) {
        System.out.println(
                "Paid in one go (day-scholar account)"
        );
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount() {
        super("Hostel");
    }

    @Override
    void processPayment(double amount) {
        System.out.println(
                "Paid in two instalments (hostel account)"
        );
    }
}

public class AccountBatchPayment {

    static void processPayment(
            FeeAccount account,
            double amount) {

        if (account instanceof HostelFeeAccount) {

            System.out.println(
                    "Paid in two instalments (hostel account)"
            );

        } else {

            System.out.println(
                    "Paid in one go (day-scholar account)"
            );
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount("Day-scholar"),
            new FeeAccount("Day-scholar")
        };

        double amount = 60000;

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount account : accounts) {

            processPayment(account, amount);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println(
                "Hostel accounts processed: "
                + hostelCount
        );

        System.out.println(
                "Day-scholar accounts processed: "
                + dayScholarCount
        );
    }
}