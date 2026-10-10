
class LibraryMember {
    int books = 0;

    void borrowBook() { books++; }

    String displayInfo() {
        return "General | Books: " + books;
    }

    int getBooksBorrowed() { return books; }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String course) {
        this.course = course;
    }

    @Override
    String displayInfo() {
        return "Student | Course: " + course + " | Books: " + books;
    }
}

public class LibraryReport {
    static String batchPrint(LibraryMember[] members) {
        StringBuilder result = new StringBuilder();

        for (LibraryMember m : members) {
            result.append(m.displayInfo());

            if (m instanceof StudentMember) {
                StudentMember s = (StudentMember) m;
                result.append(" [Course via downcast: ")
                      .append(s.course).append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember(), new StudentMember("ECE")
        };

        System.out.println(batchPrint(members));
    }
}
