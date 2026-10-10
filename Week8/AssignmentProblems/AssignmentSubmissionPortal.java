class Assignment {
    String title;
    String status = "Not Submitted";

    Assignment(String title) {
        this.title = title;
    }

    void submit() {
        if (status.equals("Not Submitted")) {
            status = "Submitted";
            System.out.println(title + " submitted successfully.");
        } else {
            System.out.println("Assignment already submitted.");
        }
    }

    void grade(int marks) {
        if (status.equals("Submitted")) {
            status = "Graded";
            System.out.println("Marks obtained: " + marks);
        } else {
            System.out.println("Submit assignment before grading.");
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Assignment a1 = new Assignment("Java Assignment");

        a1.submit();
        a1.grade(45);
        a1.submit();
    }
}