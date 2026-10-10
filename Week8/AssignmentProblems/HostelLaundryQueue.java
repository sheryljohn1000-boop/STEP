class WashingMachine {
    String id;
    boolean busy = false;

    WashingMachine(String id) {
        this.id = id;
    }

    void startWash(String student) {
        if (!busy) {
            busy = true;
            System.out.println(student + " started washing on " + id);
        } else {
            System.out.println(id + " is busy. Please wait.");
        }
    }

    void finishWash() {
        busy = false;
        System.out.println(id + " is free now.");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("Machine 1");
        WashingMachine m2 = new WashingMachine("Machine 2");

        m1.startWash("Asha");
        m1.startWash("Ravi");
        m2.startWash("Ravi");

        m1.finishWash();
        m1.startWash("Neha");
    }
}