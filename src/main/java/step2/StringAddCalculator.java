package step2;


public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isStringNullOrEmpty(text)) {
            return 0;
        }
        if (isNumber(text)) {
            return Integer.parseInt(text);
        }
        String[] splitNumbers = splitNumber(text);
        return addAllNumbers(splitNumbers);
    }

    private static int addAllNumbers(String[] splitNumbers) {
        return 0;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isStringNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitNumber(String text) {
        return new String[0];
    }
}
