package common.utils;

import common.constant.ErrorCode;

public class IntegerUtils {

    public static int parseInt(String textNumber) {
        try {
            return Integer.parseInt(textNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.정수값이_아님.getErrorMessage());
        }
    }
}
