import fraction.Fraction;
import Cat.Meower;
import ListProcessor.ListProcessor;
import MultiSportCompetition.MultiSportCompetition;
import UniqueSymbolsFinder.UniqueSymbolsFinder;
import Cat.Cat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static ReverseQueueTransfer.ReverseQueueTransfer.transferReverseOrder;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1 -> handleFractions(scanner);
                case 2 -> handleMeowingCats();
                case 3 -> handleListProcessing();
                case 4 -> handleMultiSportCompetition();
                case 5 -> handleUniqueSymbolsFinder();
                case 6 -> handlePointProcessing(scanner);
                case 7 -> streamProcessing();
                case 8 -> peopleProcessing();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            printEmptyLines();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите задание:");
        System.out.println("1(1). Работа с дробями (Шаблоны)");
        System.out.println("2(1). Мяуканье котов (Структурные шаблоны)");
        System.out.println("3(10). Обработка списка");
        System.out.println("4(10). Многофункциональные соревнования");
        System.out.println("5(10). Поиск уникальных символов");
        System.out.println("6(5). Элементы в обратном порядке");
        System.out.println("7(7.1). Стрим");
        System.out.println("8(7.2). Человек");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                scanner.next();
            }
        }
    }

    private static void printEmptyLines() {
        System.out.println("\n\n\n");
    }

    public static void handleFractions(Scanner scanner) {
        System.out.println("Выберите способ ввода данных:");
        System.out.println("1. Готовые данные");
        System.out.println("2. Ручной ввод");
        System.out.print("Ваш выбор: ");

        int inputChoice = getIntInput(scanner);
        scanner.nextLine();

        if (inputChoice == 1) {
            handlePredefinedFractions();
        } else if (inputChoice == 2) {
            handleUserDefinedFraction(scanner);
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
        }
    }

    private static void handlePredefinedFractions() {
        Fraction f = new Fraction(3, 4);
        System.out.println("Создаем дробь f = 3/4:");
        System.out.println("Дробь: " + f);
        System.out.println("Значение дроби f: " + f.getValue());

        Fraction d = new Fraction(5, 10);
        System.out.println("Создаем дробь d = 5/10:");
        System.out.println("Дробь: " + d);

        d.setNumerator(7);
        d.setDenominator(14);
        System.out.println("Теперь дробь d: " + d);
        System.out.println("Значение дроби d: " + d.getValue());

        Fraction f1 = new Fraction(6, 8);
        Fraction f2 = new Fraction(3, 4);
        System.out.println("Сравниваем дроби f1 = 6/8 и f2 = 3/4:");
        System.out.println("f1 равно f2? " + f1.equals(f2));

        Fraction f5 = new Fraction(1, 3);
        Fraction f6 = new Fraction(2, 3);
        System.out.println("Сравниваем дроби f5 = 1/3 и f6 = 2/3:");
        System.out.println("f5 равно f6? " + f5.equals(f6));

        Fraction f3 = new Fraction(-3, 4);
        Fraction f4 = new Fraction(3, -4);
        System.out.println("Сравниваем дроби f3 = -3/4 и f4 = 3/-4:");
        System.out.println("f3 равно f4? " + f3.equals(f4));

        Fraction x = new Fraction(-3, 4);
        System.out.println("Создаем дробь x = -3/4:");
        System.out.println("Дробь: " + x);

        x.setDenominator(-20);
        System.out.println("Теперь дробь x: " + x);
    }

    private static void handleUserDefinedFraction(Scanner scanner) {
        int numerator = 0;
        int denominator = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите числитель: ");
                numerator = scanner.nextInt();

                System.out.print("Введите знаменатель: ");
                denominator = scanner.nextInt();

                if (denominator == 0) {
                    System.out.println("Ошибка: знаменатель не может быть равен нулю. Попробуйте снова.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите целые числа.");
                scanner.nextLine();
            }
        }

        Fraction userFraction = new Fraction(numerator, denominator);
        System.out.println("Введенная дробь: " + userFraction);
        System.out.println("Значение дроби: " + userFraction.getValue());
    }

    public static void handleMeowingCats() {
        Cat cat = new Cat("Барсик");
        System.out.println(cat);

        List<Meower> meowers = new ArrayList<>();
        meowers.add(cat);
        meowers.add(() -> System.out.println("Неизвестное животное: мяу!"));

        Cat.makeAllMeowersMeow(meowers);

        System.out.println("Кот " + cat.getName() + " мяукнул " + cat.getMeowsCount() + " раз(а).");

        Cat cat2 = new Cat("Рыжик");
        List<Meower> meowers2 = new ArrayList<>();
        meowers2.add(cat2);
        Cat.makeAllMeowersMeow(meowers2);
        System.out.println("Кот " + cat2.getName() + " мяукнул " + cat2.getMeowsCount() + " раз(а).");
    }

    public static void handleListProcessing() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        System.out.println("Исходный список: " + input);
        List<Integer> output = ListProcessor.removeDuplicates(input);
        System.out.println("Список после удаления дубликатов: " + output);
    }

    public static void handleMultiSportCompetition() {
        try {
            File file = new File("src/input.txt");
            Scanner scanner = new Scanner(file);

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            MultiSportCompetition competition = new MultiSportCompetition(n, m, scanner);
            competition.processResults();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    public static void handleUniqueSymbolsFinder() {
        try {
            File file2 = new File("src/file.txt");
            UniqueSymbolsFinder.findUniqueSymbolsInWords(file2);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    public static void handlePointProcessing(Scanner scanner) {
        Queue<Integer> l1 = new LinkedList<>();
        System.out.println("Выберите способ ввода данных:");
        System.out.println("1. Использовать готовые данные");
        System.out.println("2. Ввести данные вручную");

        int choice = getIntInput(scanner);
        scanner.nextLine();

        if (choice == 1) {
            l1.addAll(Arrays.asList(1, 2, 3, 4, 5));
        } else if (choice == 2) {
            System.out.println("Введите числа через пробел (например: 1 2 3 4 5):");
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");
            for (String s : inputs) {
                try {
                    int number = Integer.parseInt(s);
                    l1.offer(number);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод: " + s + " - это не число. Пожалуйста, введите только целые числа.");
                    return;
                }
            }
        } else {
            System.out.println("Некорректный выбор. Пожалуйста, выберите 1 или 2.");
            return;
        }

        System.out.println("Содержимое первой очереди до переноса: " + l1);

        Queue<Integer> l2 = new LinkedList<>();
        transferReverseOrder(l1, l2);

        System.out.print("Содержимое второй очереди после переноса: ");
        while (!l2.isEmpty()) {
            System.out.print(l2.poll() + " ");
        }
        System.out.println();
    }

    public static void streamProcessing() {
        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(3, 4),
                new Point(1, 2), // Дубликат
                new Point(5, -6),
                new Point(2, 7),
                new Point(5, -6) // Дубликат
        );

        System.out.println("Точки до преобразования:");
        points.forEach(System.out::println);

        Polyline polyline = processPoints(points);
        System.out.println("Преобразованная линия:");
        System.out.println(polyline);

        List<Point> points2 = List.of(
                new Point(10, 20),
                new Point(2, 1),
                new Point(3, 4),
                new Point(1, 2),
                new Point(5, 6),
                new Point(7, 8),
                new Point(9, 10),
                new Point(11, -1),
                new Point(12, 2),
                new Point(13, 1),
                new Point(10, 20)
        );

        System.out.println("Вторые точки до преобразования:");
        points2.forEach(System.out::println);

        Polyline polyline2 = processPoints(points2);
        System.out.println("Преобразованная линия для второго списка:");
        System.out.println(polyline2);
    }

    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .peek(point -> {
                    if (point.getY() < 0) {
                        point.setY(-point.getY());
                    }
                })
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }

    public static void peopleProcessing() {
        String filePath = "src/people.txt";
        try {
            Map<Integer, List<String>> groupedPeople = PeopleFromFile.processPeopleFromFile(filePath);
            System.out.println(groupedPeople);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}