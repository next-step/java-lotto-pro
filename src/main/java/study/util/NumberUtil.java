package study.util;

import study.message.NumberExceptionCode;

public class NumberUtil {

    public static final int INIT_ZERO = 0;
    public static final long INIT_ZERO_LONG = 0L;

    private NumberUtil() {}

    public static int convertToPositiveIntNotContainsZero(String str) {
        int convertNum = convertToPositiveInt(str);

        if(convertNum != INIT_ZERO) {
            return convertNum;
        }

        throw new IllegalArgumentException(NumberExceptionCode.NOT_CONTAINS_ZERO.getMessage());
    }

    public static int convertToPositiveInt(String str) {
        try {
            int num = Integer.parseInt(str);
            checkNegativeNumber(num);

            return num;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(
                    NumberExceptionCode.INVALID_NUMBER_STRING.getMessage());
        }
    }

    private static void checkNegativeNumber(int num) {
        if(num >= INIT_ZERO) {
            return;
        }

        throw new IllegalArgumentException(
                NumberExceptionCode.NOT_CONTAINS_NEGATIVE_NUMBER.getMessage());
    }

    public static long divideAndCeil(long leftOperand, long rightOperand) {
        if(leftOperand <= INIT_ZERO_LONG || rightOperand <= INIT_ZERO_LONG) {
            throw new ArithmeticException(NumberExceptionCode.NOT_DIVIDE_ZERO.getMessage());
        }

        return (long) Math.ceil(leftOperand/rightOperand);
    }

}
