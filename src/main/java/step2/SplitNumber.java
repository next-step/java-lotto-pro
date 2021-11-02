package step2;

public class SplitNumber {

    public static int valueOf(String value) {
        valid(value);
        return Integer.parseInt(value);
    }

    private static void valid(String value) {
        if (Integer.parseInt(value) < 0 || !isNumber(value)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
