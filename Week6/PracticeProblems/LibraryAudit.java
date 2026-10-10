
class LibraryMember {
    private static int counter = 0;
    public final int memberNumber;
    private int books = 0;

    LibraryMember(int limit) {
        memberNumber = ++counter;
    }

    void borrowBook() {
        books++;
    }

    void borrowBook(String genre) {
        System.out.println("Genre: " + genre);
        borrowBook();
    }

    int getBooksBorrowed() { return books; }

    static int getMembersEnrolled() { return counter; }

    String getMemberCode() {
        return "LIB-" + (100 + memberNumber);
    }

    static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;

        return code.charAt(0) == 'R'
            && Character.isDigit(code.charAt(1))
            && Character.isDigit(code.charAt(2))
            && Character.isUpperCase(code.charAt(3));
    }
}

class FacultyMember extends LibraryMember {
    String department;

    FacultyMember(int limit, String department) {
        super(limit);
        this.department = department;
    }
}

public class LibraryAudit {
    static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, skipped = 0, faculty = 0, regular = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                skipped++;
                continue;
            }

            processed++;

            if (m instanceof FacultyMember)
                faculty++;
            else
                regular++;
        }

        return processed + " processed | " + skipped
            + " null skipped | " + faculty + " faculty | "
            + regular + " regular";
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember(3);

        m.borrowBook();
        m.borrowBook("Fiction");

        System.out.println(m.getBooksBorrowed());
        System.out.println(m.getMemberCode());
        System.out.println(LibraryMember.isValidRenewalCode("R12A"));

        System.out.println(processNightlyAudit(new LibraryMember[]{
            new FacultyMember(5, "Physics"), null, new LibraryMember(3)
        }));
    }
}
