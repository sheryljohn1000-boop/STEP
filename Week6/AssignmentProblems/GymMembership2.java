
class GymMember {
    String memberId;
    int monthlyFee, sessions = 0;

    GymMember(String id, int fee) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException();
        memberId = id;
        monthlyFee = fee;
    }

    void attendSession() { sessions++; }
    int getSessionsAttended() { return sessions; }

    void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessions);
    }

    static String classifyGeneration(GymMember m) {
        if (m instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";
        if (m instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";
        if (m instanceof PremiumMember)
            return "Second generation";
        return "Base class";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember m : members)
            total += m.getSessionsAttended();
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
    void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName
                           + " | Sessions: " + sessions);
    }
}

class EliteMember extends PremiumMember {
    String lockerNumber;

    EliteMember(String id, int fee, String trainer, String locker) {
        super(id, fee, trainer);
        lockerNumber = locker;
    }

    @Override
    void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainerName
                + " | Locker: " + lockerNumber + " | Sessions: " + sessions);
    }
}

class GroupClassMember extends GymMember {
    String className;

    GroupClassMember(String id, int fee, String name) {
        super(id, fee);
        className = name;
    }

    @Override
    void displayInfo() {
        System.out.println("Group Class Member | Class: " + className
                           + " | Sessions: " + sessions);
    }
}

public class GymMembership2 {
    public static void main(String[] args) {
        GymMember[] members = {
            new PremiumMember("MEM1", 2000, "Riya"),
            new EliteMember("MEM2", 3000, "Arjun", "L12"),
            new GroupClassMember("MEM3", 1500, "Zumba")
        };

        members[0].attendSession();
        members[0].attendSession();
        members[1].attendSession();

        System.out.println(GymMember.getTotalSessionsAttended(members));
        System.out.println(GymMember.classifyGeneration(members[1]));
    }
}
