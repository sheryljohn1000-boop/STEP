
class LibraryMember {
    private int[] history = new int[10];
    private int count = 0;

    LibraryMember(String id, int limit) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException();
    }

    protected void chargeFine(int amount) {
        if (count < history.length)
            history[count++] = amount;
    }

    int[] getFineHistory() {
        return java.util.Arrays.copyOf(history, count);
    }

    int getTotalFine() {
        int total = 0;
        for (int i = 0; i < count; i++)
            total += history[i];
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
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class LibraryFineTest {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);

        System.out.println(s.getTotalFine());
        System.out.println(java.util.Arrays.toString(s.getFineHistory()));
    }
}
