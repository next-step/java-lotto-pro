import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiters {

    Set<String> delimiters = new HashSet<>();

    public Delimiters(List<String> defaultDelimiters) {
        delimiters.addAll(defaultDelimiters);
    }

    public void add(String customDelimiter) {
        if (customDelimiter != null && !customDelimiter.equals("")) {
            this.delimiters.add(customDelimiter);
        }
    }

    public String join() {
        return String.join("|", this.delimiters);
    }
}
