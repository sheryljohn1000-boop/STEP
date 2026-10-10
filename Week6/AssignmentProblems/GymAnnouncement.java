
class GymMember {
    int sessions = 0;

    void displayInfo() {
        System.out.print("Standard | Sessions: " + sessions);
    }

    int getSessionsAttended() { return sessions; }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String trainer) {
        trainerName = trainer;
    }

    @Override
    void displayInfo() {
        System.out.print("Premium | Trainer: " + trainerName
                         + " | Sessions: " + sessions);
    }
}

public class GymAnnouncement {
    static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember m : members) {
            java.io.ByteArrayOutputStream output =
                new java.io.ByteArrayOutputStream();
            java.io.PrintStream old = System.out;
            System.setOut(new java.io.PrintStream(output));

            m.displayInfo();

            System.setOut(old);
            result.append(output.toString());

            if (m instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) m;
                result.append(" [Trainer via downcast: ")
                      .append(p.trainerName).append("]");
            }
            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember(), new PremiumMember("Coach Riya")
        };
        System.out.println(batchPrint(members));
    }
}
