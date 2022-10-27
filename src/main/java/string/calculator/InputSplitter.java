package string.calculator;

public class InputSplitter {
    private final String input;

    public InputSplitter(String input) {
        this.input = input;
    }

    public String[] split() {
        final DelimiterFinder delimiterFinder = new DelimiterFinder(input);
        final String delimiter = delimiterFinder.find();
        final String purifiedInput = purifyInput(input);
        String splitRegex = delimiter;
        if (ifDelimiterRegexReservedWord(delimiter)) {
            splitRegex = String.format("\\%s", delimiter);
        }
        return purifiedInput.split(splitRegex);
    }

    private String purifyInput(String input) {
        final int purifyTarget = findPurifyTarget(input);
        if (purifyTargetNotFound(purifyTarget)) {
            return input;
        }
        return input.substring(purifyTarget + 2);
    }

    private int findPurifyTarget(String input) {
        return input.indexOf("\\n");
    }

    private boolean purifyTargetNotFound(int purifyTarget) {
        return purifyTarget == -1;
    }

    private boolean ifDelimiterRegexReservedWord(String delimiter) {
        return "+*?.^&".contains(delimiter);
    }
}
