import java.util.List;
import java.util.Optional;

public class LongestName {
    public static Optional<String> longestName(List<Optional<String>> maybeNames) {
        if (maybeNames.isEmpty()) {
            return Optional.empty();
        }
        int check = 0;
        Optional<String> max = maybeNames.get(0);
        for (Optional<String> maybeName : maybeNames) {
            if (maybeName.isPresent()) {
                if (max.isEmpty()) {
                    max = maybeNames.get(check);
                } else if (max.get().length() < maybeName.get().length()) {
                    max = maybeName;
                }
            } else {
                check++;
                if (check == maybeNames.size()) {
                    return Optional.empty();
                }
            }
        }
        return max;
    }

    // Если все возможные имена — пустые или пуст сам список, верните пустой Optional<String>.

    public static void main(String[] args) {
        Optional<String> longestOptional = longestName(List.of(
                Optional.empty(),
                null,                                           //Не проходи мимо,) подумай насчёт этого
                //Optional.of("Max"),
                Optional.empty(),
                //Optional.of("Alexey"),
                Optional.empty(),
                Optional.empty(),
                //Optional.of("Alex"),
                Optional.empty()
        ));
        if (longestOptional.isPresent()) {
            String longestName = longestOptional.get();
            System.out.println("Самое длинное имя состоит из "
                    + longestName.length() + " символов.");
        } else {
            System.out.println("Список имен пуст!");
        }
    }
}
