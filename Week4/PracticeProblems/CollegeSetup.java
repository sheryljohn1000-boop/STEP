class CollegeSetup {

    static String collegeName;
    static String academicYear;

    // Static block
    static {

        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";

        System.out.println("College info loaded");
    }

    String studentName;

    CollegeSetup(String studentName) {
        this.studentName = studentName;
    }

    void printStudent() {
        System.out.println(
                "Student record created: " + studentName
        );
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        CollegeSetup[] students =
                new CollegeSetup[names.length];

        for (int i = 0; i < names.length; i++) {

            students[i] =
                    new CollegeSetup(names[i]);

            students[i].printStudent();
        }
    }
}