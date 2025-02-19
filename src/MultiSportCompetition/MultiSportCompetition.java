package MultiSportCompetition;

import java.util.*;

/**
 * Класс для обработки результатов многоборья.
 */
public class MultiSportCompetition {
    private final int n;
    private final int m;
    private final Scanner scanner;

    /**
     * Создает объект для обработки результатов.
     *
     * @param n       Количество участников.
     * @param m       Количество видов спорта.
     * @param scanner Сканер для чтения данных.
     */
    public MultiSportCompetition(int n, int m, Scanner scanner) {
        this.n = n;
        this.m = m;
        this.scanner = scanner;
    }

    /**
     * Обрабатывает результаты и выводит их.
     */
    public void processResults() {
        Map<String, Integer> athletes = new TreeMap<>();
        Map<String, Integer> places = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");

            String fullName = parts[0] + " " + parts[1];
            int totalScore = 0;

            for (int j = 2; j < parts.length; j++) {
                totalScore += Integer.parseInt(parts[j]);
            }

            athletes.put(fullName, totalScore);
        }

        List<Map.Entry<String, Integer>> sortedAthletes = new ArrayList<>(athletes.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(sortedAthletes, comparator.reversed());

        int place = 1;
        int previousTotal = -1;
        for (Map.Entry<String, Integer> entry : sortedAthletes) {
            if (previousTotal != entry.getValue()) {
                places.put(entry.getKey(), place);
                previousTotal = entry.getValue();
            } else {
                places.put(entry.getKey(), place - 1);
            }
            place++;
        }

        for (Map.Entry<String, Integer> entry : sortedAthletes) {
            String athlete = entry.getKey();
            int score = entry.getValue();
            int position = places.get(athlete);
            System.out.printf("%s %d %d\n", athlete, score, position);
        }
    }
}