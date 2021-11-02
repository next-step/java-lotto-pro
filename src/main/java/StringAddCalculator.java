import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) return 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = m.group(2).split(customDelimiter);
            return sumStringNumberArray(numbers);
        }

        if (inputText.contains(",") || inputText.contains(":")) {
            String[] numbers = inputText.split(",|:");
            return sumStringNumberArray(numbers);
        }

        return Integer.parseInt(inputText);
    }

    private static int sumStringNumberArray(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            checkValidateNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void checkValidateNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
