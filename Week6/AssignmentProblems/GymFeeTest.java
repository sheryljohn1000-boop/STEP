
class GymMember {
    String memberId;
    int monthlyFee;
    private int[] history = new int[10];
    private int count = 0;

    GymMember(String id, int fee) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException();
        memberId = id;
        monthlyFee = fee;
    }

    protected void chargeLateFee(int amount) {
        if (count < history.length)
            history[count++] = amount;
    }

    int[] getLateFeeHistory() {
        return java.util.Arrays.copyOf(history, count);
    }

    int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < count; i++)
            total += history[i];
        return total;
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String id, int fee, String trainer) {
        super(id, fee);
        trainerName = trainer;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class GymFeeTest {
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());
        System.out.println(java.util.Arrays.toString(p.getLateFeeHistory()));
    }
}
