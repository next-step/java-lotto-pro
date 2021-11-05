package study;

public class CustomedText extends Text {

    private final String text;
    private final String delimeter;

    public CustomedText(String text, String delimeter) {
        this.text = text;
        this.delimeter = delimeter;
        validateDelimeter();
    }

    protected void validateDelimeter() {
        if(text.matches(".*\\d[^"+delimeter+"]\\d.*")) {
            throw new RuntimeException(StringAddCalculator.INVALID_CUSTOM_PATTERN_ERR_MSG);
        }
    }

    @Override
    public String[] splitWithDelimeter() {
        return text.split(delimeter);
    }
}
