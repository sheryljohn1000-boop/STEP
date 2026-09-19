class LibraryBook {

    String title;
    String isbn;

    // Constructor with title and ISBN
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    // Constructor with only title
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    void printBook() {

        boolean catalogued = !isbn.equals("PENDING");

        System.out.println(
                title + " | " + isbn
                + " | Catalogued: " + catalogued
        );
    }

    public static void main(String[] args) {

        String[] titles = {
            "Clean Code",
            "Untitled Draft",
            "1984",
            "Notes"
        };

        String[] isbns = {
            "978-0132350884",
            "9780451549923",
            "",
            ""
        };

        LibraryBook[] books = new LibraryBook[4];

        for (int i = 0; i < titles.length; i++) {

            if (!isbns[i].isEmpty()) {
                books[i] = new LibraryBook(titles[i], isbns[i]);
            } else {
                books[i] = new LibraryBook(titles[i]);
            }
        }

        for (LibraryBook book : books) {
            book.printBook();
        }
    }
}