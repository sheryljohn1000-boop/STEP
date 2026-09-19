import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    static String normalizeCode(String raw) {

        return raw.trim().replace(" ", "").toUpperCase();
    }

    static String validateAndFormat(String code) {

        // Check total length
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check next 4 characters are digits
        for (int i = 3; i < 7; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year must be 4 digits";
            }
        }

        // Check last 6 characters are digits
        for (int i = 7; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: catalog number must be 6 digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        return "[" + publisher + "] YEAR: " + year
                + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}