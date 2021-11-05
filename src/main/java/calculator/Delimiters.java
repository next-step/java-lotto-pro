package calculator;

import java.util.Objects;

public class Delimiters {
    private static final String DEFAULT_DELIMITER1 = ",";
    private static final String DEFAULT_DELIMITER2 = ":";
    private static final String DELIMITER_OF_DELIMITERS = "|";
    private String delimiters;

    public Delimiters() {
        this(null);
    }

    public Delimiters(String delimiter) {
        this.delimiters = "";
        addDelimiter(DEFAULT_DELIMITER1);
        addDelimiter(DEFAULT_DELIMITER2);
        addCustomDelimiter(delimiter);
    }

    private void addCustomDelimiter(String delimiter) {
        if (delimiter == null) {
            return;
        }

        addDelimiter(delimiter);
    }

    private void addDelimiter(String delimiter) {
        if (this.delimiters.length() == 0) {
            this.delimiters += delimiter;
            return;
        }

        this.delimiters += DELIMITER_OF_DELIMITERS + delimiter;
    }

    public String[] splitTextByDelimiter(String text) {
        return text.split(delimiters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiters delimiters2 = (Delimiters) o;
        return Objects.equals(delimiters, delimiters2.delimiters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters);
    }
}
