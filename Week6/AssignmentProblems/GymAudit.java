
class GymMember {
    private static int counter = 0;
    private final String membershipNumber;
    int feesPaid = 0;

    GymMember(int monthlyFee) {
        counter++;
        membershipNumber = "GYM-" + (2000 + counter);
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        System.out.println("Payment mode: " + mode);
        payFee(amount);
    }

    int getFeesPaid() { return feesPaid; }

    static int getMembersEnrolled() { return counter; }

    String getMembershipNumber() { return membershipNumber; }

    static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;

        return code.charAt(0) == 'G'
            && Character.isDigit(code.charAt(1))
            && Character.isDigit(code.charAt(2))
            && Character.isUpperCase(code.charAt(3));
    }
}

class GroupClassMember extends GymMember {
    String className;

    GroupClassMember(int fee, String name) {
        super(fee);
        className = name;
    }
}

public class GymAudit {
    static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, skipped = 0, group = 0, individual = 0;

        for (GymMember m : members) {
            if (m == null) {
                skipped++;
                continue;
            }

            processed++;
            if (m instanceof GroupClassMember)
                group++;
            else
                individual++;
        }

        return processed + " processed | " + skipped
            + " null skipped | " + group + " group | "
            + individual + " individual";
    }

    public static void main(String[] args) {
        GymMember m = new GymMember(1000);
        m.payFee(500);
        m.payFee(500, "UPI");

        System.out.println(m.getFeesPaid());
        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymAudit.processWeeklyCheckIn(
            new GymMember[]{new GroupClassMember(1500, "Zumba"),
                            null, new GymMember(1000)}));
    }
}
