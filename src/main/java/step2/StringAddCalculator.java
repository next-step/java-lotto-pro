package step2;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        return 1;
    }
}
