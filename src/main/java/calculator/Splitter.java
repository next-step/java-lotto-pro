package calculator;

public class Splitter {

    public static final String COMMA = ",";

    public static Numbers split(String input) {
        return new Numbers(input.split(COMMA));
    }
}
