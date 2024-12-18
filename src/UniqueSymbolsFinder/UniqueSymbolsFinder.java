package UniqueSymbolsFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueSymbolsFinder {
    public static void findUniqueSymbolsInWords(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Map<Character, Integer> charCount = new HashMap<>();
        Set<String> words = new HashSet<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(Locale.ROOT)
                    .replaceAll("[^а-яА-Яa-zA-Z]", "");

            if (!word.isEmpty()) {
                words.add(word);

                for (char c : word.toCharArray()) {
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
            }
        }

        scanner.close();


        Set<Character> uniqueChars = new HashSet<>();

        for (String word : words) {
            Set<Character> wordChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                wordChars.add(c);
            }


            for (char c : wordChars) {
                if (charCount.get(c) == 1) {
                    uniqueChars.add(c);
                }
            }
        }

        System.out.println("Символы, встречающиеся в одном и только в одном слове:");
        System.out.println(uniqueChars);
    }

}
