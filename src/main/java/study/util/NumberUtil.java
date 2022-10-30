package study.util;

public class NumberUtil {

    public static final int INIT_ZERO = 0;
    public static final long INIT_ZERO_LONG = 0L;

    public static int convertToPositiveIntNotContainsZero(String str) {
        int convertNum = convertToPositiveInt(str);

        if(convertNum != INIT_ZERO) {
            return convertNum;
        }

        throw new IllegalArgumentException("[ERROR] The given string cannot contain zero.");
    }

    public static int convertToPositiveInt(String str) {
        try {
            int num = Integer.parseInt(str);
            checkNegativeNumber(num);

            return num;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(
                    "[ERROR] The given string contains characters " +
                            "that cannot be converted to numbers.");
        }
    }

    private static void checkNegativeNumber(int num) {
        if(num >= INIT_ZERO) {
            return;
        }

        throw new IllegalArgumentException(
                "[ERROR] The given string cannot contain negative numbers.");
    }

    public static long divideAndCeil(long leftOperand, long rightOperand) {
        if(leftOperand <= INIT_ZERO_LONG || rightOperand <= INIT_ZERO_LONG) {
            throw new ArithmeticException("[ERROR] It cannot be divided by zero.");
        }

        return (long) Math.ceil(leftOperand/rightOperand);
    }

}
