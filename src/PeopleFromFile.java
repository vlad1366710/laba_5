import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PeopleFromFile {

    public static Map<Integer, List<String>> processPeopleFromFile(String filePath) throws IOException {

        Pattern pattern = Pattern.compile("([a-zA-Zа-яА-Я]+):(\\d+)");

        return Files.lines(Paths.get(filePath))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    if(matcher.find()) {
                        return new String[]{matcher.group(1), matcher.group(2)};
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .filter(parts -> parts.length == 2)
                .map(parts -> {
                    String name = parts[0];
                    int number = Integer.parseInt(parts[1]);
                    return new String[]{capitalizeFirstLetter(name), String.valueOf(number)};
                })
                .collect(Collectors.groupingBy(parts -> Integer.parseInt(parts[1]), Collectors.mapping(parts -> parts[0], Collectors.toList())));

    }

    private static String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
