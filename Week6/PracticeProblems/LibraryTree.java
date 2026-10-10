
class LibraryMember {
    String memberId;
    int borrowLimit, books = 0;

    LibraryMember(String id, int limit) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException();
        memberId = id;
        borrowLimit = limit;
    }

    void borrowBook() { books++; }
    int getBooksBorrowed() { return books; }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + books);
    }

    static String classifyGeneration(LibraryMember m) {
        if (m instanceof HonorsStudentMember)
            return "Multilevel descendant (3 generations deep)";
        if (m instanceof FacultyMember)
            return "Hierarchical sibling (independent branch)";
        if (m instanceof StudentMember)
            return "Second generation";
        return "Base class";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members)
            total += m.getBooksBorrowed();
        return total;
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String id, int limit, String course) {
        super(id, limit);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.println("Student Member | Course: " + course
                           + " | Books Borrowed: " + books);
    }
}

class HonorsStudentMember extends StudentMember {
    int bonusLimit;

    HonorsStudentMember(String id, int limit, String course, int bonus) {
        super(id, limit, course);
        bonusLimit = bonus;
    }

    @Override
    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course
            + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + books);
    }
}

class FacultyMember extends LibraryMember {
    String department;

    FacultyMember(String id, int limit, String dept) {
        super(id, limit);
        department = dept;
    }

    @Override
    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department
                           + " | Books Borrowed: " + books);
    }
}

public class LibraryTree {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("STU1", 3, "CSE"),
            new HonorsStudentMember("STU2", 5, "ECE", 2),
            new FacultyMember("FAC1", 5, "Physics")
        };

        members[0].borrowBook();
        members[0].borrowBook();
        members[1].borrowBook();
        members[2].borrowBook();
        members[2].borrowBook();
        members[2].borrowBook();

        System.out.println(LibraryMember.getTotalBooksBorrowed(members));
        System.out.println(LibraryMember.classifyGeneration(members[1]));
    }
}
