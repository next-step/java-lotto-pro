package string.calculator;

public class DelimiterFinder {
    private final String input;

    public DelimiterFinder(String input) {
        this.input = input;
    }

    public boolean ifIncludeBothSlashAndNewline() {
        return input.contains("//") && input.contains("\\n");
    }
}
