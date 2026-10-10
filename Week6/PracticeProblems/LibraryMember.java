
public class LibraryMember {
    protected String memberId;
    protected int borrowLimit, books = 0;

    public LibraryMember(String id, int limit) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException("Invalid ID");
        memberId = id;
        borrowLimit = limit;
    }

    public void borrowBook() { books++; }
    public int getBooksBorrowed() { return books; }

    public void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + books);
    }

    static String enrollBatch(String[] ids, int limit) {
        int enrolled = 0, rejected = 0;

        for (String id : ids) {
            try {
                new LibraryMember(id, limit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        System.out.println(enrollBatch(
            new String[]{"STU1", "LB1", "STU2", " ", "STU3"}, 3));
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String id, int limit, String course) {
        super(id, limit);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Member | Course: " + course
                           + " | Books Borrowed: " + books);
    }
}
