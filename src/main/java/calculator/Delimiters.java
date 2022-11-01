package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    private static final Pattern regex = Pattern.compile("//(.)\n(.*)");
    private static final List<String> defaultDelimiters = List.of(",", ":");
    public static final int CUSTOM_DELIMITER = 1;
    private Set<String> delimiters = new HashSet<>();

    public Delimiters(String text) {
        delimiters.addAll(defaultDelimiters);
        addCustomDelimiter(text);
    }

    public void addCustomDelimiter(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return;
        }
        Matcher m = regex.matcher(text);
        if (m.find()) {
            this.delimiters.add(m.group(CUSTOM_DELIMITER));
        }
    }

    public String delimiter() {
        return String.join("|", this.delimiters);
    }
}
