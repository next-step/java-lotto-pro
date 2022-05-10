package stringcalculator;

public class SplitUtils {

    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] splitByDefaultDelimiter(String input) {
        return split(input, DEFAULT_DELIMITER);
    }

    private String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

}
