package calculator;

import java.util.Objects;

public class Delimiters {
    private static final String DELIMITER_OF_DELIMITERS = "|";
    private String delimiters;

    public Delimiters(String delimiters) {
        this.delimiters = "";
        addCustomDelimiters(delimiters);
    }

    private void addCustomDelimiters(String delimiters) {
        for (String delimiter: delimiters.split("")) {
            addDelimiter(delimiter);
        }
    }

    private void addDelimiter(String delimiter) {
        if (this.delimiters.length() != 0) {
            this.delimiters += DELIMITER_OF_DELIMITERS;
        }

        this.delimiters += delimiter;
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
