class Membership {
    String name;
    String status = "Active";
    double fee;

    Membership(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied. Status: " + status);
        }
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println("Membership frozen.");
        } else {
            System.out.println("Cannot freeze membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println("Membership activated.");
        } else {
            System.out.println("Membership is not frozen.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println("Membership expired.");
    }
}

public class FitZoneMembership {
    public static void main(String[] args) {
        Membership m = new Membership("Asha", 1000);

        System.out.println("Membership fee: " + m.fee);
        m.checkIn();
        m.freeze();
        m.checkIn();
        m.unfreeze();
        m.checkIn();
        m.expire();
        m.checkIn();
    }
}