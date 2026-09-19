import java.util.Scanner;

class BankTransactionReference {

    String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() >= 3) {
            String bankCode =
                    reference.substring(0, 3).toUpperCase();

            reference = bankCode + reference.substring(3);
        }

        return reference;
    }

    String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);
        String formattedDate =
                date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);
        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(formattedDate)
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        BankTransactionReference obj =
                new BankTransactionReference();

        // Step 1: Normalize
        String normalized = obj.normalizeReference(raw);

        // Step 2: Validate and format
        System.out.println(obj.validateAndFormat(normalized));
    }
}