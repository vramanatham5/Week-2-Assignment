import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String paragraph = scanner.nextLine()
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "the", "was", "and", "a", "is", "of", "in"));
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> frequencies = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
