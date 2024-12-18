package ListProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListProcessor {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer item : list) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }

        return result;
    }
}