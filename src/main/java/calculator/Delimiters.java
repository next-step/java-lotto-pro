package calculator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Delimiters {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private Set<String> delimiters = new HashSet<>();

    public Delimiters() {
        Collections.addAll(delimiters, DEFAULT_DELIMITERS);
    }

    public void add(String delimiter) {
        this.delimiters.add(delimiter);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String delimiter() {
        return String.join("|", this.delimiters);
    }
}
