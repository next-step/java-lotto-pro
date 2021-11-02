package step2;

public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        if (str.length() == 1) {
            return Integer.parseInt(str);
        }

        return 1;
    }
}
