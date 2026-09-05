import java.util.*;

class FirstNonRepeatingCharacter {
    static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        //  Count frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        //  Scan from left to right
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // If character appears only once
            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        // No non-repeating character found
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println(
                "First Non-Repeating Character: '" + result + "'"
            );
        }

        sc.close();
    }
}