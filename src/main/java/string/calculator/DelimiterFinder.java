package string.calculator;

public class DelimiterFinder {
    private final String input;

    public DelimiterFinder(String input) {
        this.input = input;
    }

    public boolean ifIncludeBothSlashAndNewline() {
        return input.contains("//") && input.contains("\\n");
    }

    public boolean customDelimiterExistsInBetween() {
        final int indexOfDoubleSlash = input.indexOf("//");
        final int indexOfNewline = input.indexOf("\\n");
        if (indexOfDoubleSlash + 2 == indexOfNewline) {
            return false;
        }
        final String customDelimiter = input.substring(indexOfDoubleSlash + 2, indexOfNewline);
        if (1 < customDelimiter.length()) {
            return false;
        }
        final char charCustomDelimiter = customDelimiter.charAt(0);
        if (Character.isDigit(charCustomDelimiter)) {
            return false;
        }
        return true;
    }
}
