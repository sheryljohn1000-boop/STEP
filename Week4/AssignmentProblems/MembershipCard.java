class MembershipCard {

    static String libraryName;
    static String validUntil;

    String studentName;

    // Static block runs only once
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    // Constructor
    MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {

        String[] names = {
            "Ananya",
            "Rohan",
            "Priya",
            "Arjun",
            "Sneha"
        };

        for (String name : names) {

            MembershipCard card =
                new MembershipCard(name);

            System.out.println(
                "Membership card issued: " + card.studentName
            );
        }
    }
}