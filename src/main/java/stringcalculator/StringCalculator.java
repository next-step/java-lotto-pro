package stringcalculator;

public class StringCalculator {

    private static final String SEPARATOR = ",|:";

    public static String[] separator(String inputString) {
        return inputString.split(SEPARATOR);
    }
}
