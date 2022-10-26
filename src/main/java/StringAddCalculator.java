public class StringAddCalculator {

    public static final String DELIMITER_REGEX = ",|:";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return sum(text.split(DELIMITER_REGEX));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(String[] splitText) {
        int sum = 0;
        for (String number : splitText) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
