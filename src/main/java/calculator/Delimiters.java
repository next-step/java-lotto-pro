package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiters {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private Set<String> delimiters = new HashSet<>();

    public Delimiters() {
        delimiters.addAll(DEFAULT_DELIMITERS);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String delimiter() {
        return String.join("|", this.delimiters);
    }

    public void add(String delimiter) {
        this.delimiters.add(delimiter);
    }
}
