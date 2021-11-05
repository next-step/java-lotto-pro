package study;

public class Text {

    private static final String DEFAULT_DELIMETER = ",|:";

    private final String text;

    public Text() {
        this.text = "";
    }

    public Text(String text) {
        this.text = text;
    }

    public String[] splitWithDelimeter() {
        return text.split(DEFAULT_DELIMETER);
    }
}
