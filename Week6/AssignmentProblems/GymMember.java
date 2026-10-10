
public class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessions = 0;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4)
            throw new IllegalArgumentException("Invalid ID");

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessions++;
    }

    public int getSessionsAttended() {
        return sessions;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessions);
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signed = 0, rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signed++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signed + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        System.out.println(signUpBatch(
            new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName
                           + " | Sessions: " + sessions);
    }
}
