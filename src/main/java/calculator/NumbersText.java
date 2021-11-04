package calculator;

public class NumbersText {
    private final String numbersText;

    public NumbersText(String numbersText) {
        this.numbersText = numbersText;
    }

    public boolean isNullOrEmptyString() {
        return numbersText == null || numbersText.length() == 0;
    }

    public String[] splitNumbersText(Delimiters delimiters) {
        if (isNullOrEmptyString()) {
            return null;
        }

        return delimiters.splitTextByDelimiter(numbersText);
    }
}
