class Employee {
    String name;
    String status = "Pending";

    Employee(String name) {
        this.name = name;
    }

    void review(String decision) {
        if (status.equals("Pending")) {
            status = decision;
            System.out.println(name + "'s leave: " + status);
        } else {
            System.out.println("Request already reviewed.");
        }
    }
}

public class LeaveManagement {
    public static void main(String[] args) {
        Employee e1 = new Employee("John");

        System.out.println("Leave request submitted.");
        e1.review("Approved");
        e1.review("Rejected");
    }
}
