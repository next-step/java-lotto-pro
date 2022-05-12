package calculator.parser;

import calculator.common.ErrorMessage;

public class StringToIntegerParser {

    private final String str;

    public StringToIntegerParser(String str) {
        this.str = str;
    }

    public int parseInt() {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT);
        }
    }
}
