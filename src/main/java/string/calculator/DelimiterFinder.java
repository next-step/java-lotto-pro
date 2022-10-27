package string.calculator;

public class DelimiterFinder {
    private final String input;
    private String ultimateCustomDelimiter = null;

    public DelimiterFinder(String input) {
        this.input = input;
    }

    public String find() {
        if (ifIncludeBothSlashAndNewline() && customDelimiterExistsInBetween()) {
            return ultimateCustomDelimiter;
        }
        return "[:,]";
    }

    public boolean ifIncludeBothSlashAndNewline() {
        return input.contains("//") && input.contains("\\n");
    }

    public boolean customDelimiterExistsInBetween() {
        final int indexOfDoubleSlash = input.indexOf("//");
        final int indexOfNewline = input.indexOf("\\n");
        if (noSpaceBetweenDoubleSlashAndNewline(indexOfDoubleSlash, indexOfNewline)) {
            return false;
        }
        final String customDelimiter = input.substring(indexOfDoubleSlash + 2, indexOfNewline);
        if (customDelimiterMoreThanOne(customDelimiter)) {
            return false;
        }
        final char charCustomDelimiter = customDelimiter.charAt(0);
        if (isCustomDelimiterDigit(charCustomDelimiter)) {
            return false;
        }
        ultimateCustomDelimiter = "" + charCustomDelimiter;
        return true;
    }

    private boolean noSpaceBetweenDoubleSlashAndNewline(int indexOfDoubleSlash, int indexOfNewline) {
        return indexOfDoubleSlash + 2 == indexOfNewline;
    }

    private boolean customDelimiterMoreThanOne(String customDelimiter) {
        return 1 < customDelimiter.length();
    }

    private boolean isCustomDelimiterDigit(char charCustomDelimiter) {
        return Character.isDigit(charCustomDelimiter);
    }
}
