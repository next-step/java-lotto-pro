package calculator;

import java.util.Objects;

public class Delimiters {
    private static final String DELIMITER_OF_DELIMITERS = "|";
    private final StringBuilder delimiters;

    public Delimiters(String delimiters) {
        this.delimiters = new StringBuilder();
        addCustomDelimiters(delimiters);
    }

    private void addCustomDelimiters(String delimiters) {
        for (String delimiter: delimiters.split("")) {
            addDelimiter(delimiter);
        }
    }

    private void addDelimiter(String delimiter) {
        if (!this.delimiters.isEmpty()) {
            this.delimiters.append(DELIMITER_OF_DELIMITERS);
        }

        this.delimiters.append(delimiter);
    }

    public String[] splitTextByDelimiter(String text) {
        return text.split(delimiters.toString());
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
