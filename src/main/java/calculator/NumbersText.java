package calculator;

public class NumbersText {
    private final String numbersText;

    public NumbersText(String numbersText) {
        this.numbersText = numbersText;
    }

    public String[] splitNumbersText(Delimiters delimiters) {
        return delimiters.splitTextByDelimiter(numbersText);
    }
}
