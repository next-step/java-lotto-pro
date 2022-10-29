package common.utils;

import common.constant.ErrorCode;

public class LongUtils {

    public static long parseLong(String textNumber) {
        try {
            return Long.parseLong(textNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.정수값이_아님.getErrorMessage());
        }
    }
}
