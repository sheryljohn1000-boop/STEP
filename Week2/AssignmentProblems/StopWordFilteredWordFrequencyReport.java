import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in", "to"
        };

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            // Check if word is a stop word
            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count frequency
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Convert map to list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}