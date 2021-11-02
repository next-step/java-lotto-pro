package calculator;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public boolean isNullOrEmpty() {
        return input == null || input.isEmpty();
    }

    public String[] split() {
        return Separator.split(input);
    }

}
