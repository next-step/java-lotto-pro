package lotto.utils;

import lotto.cons.ErrorMessageConst;

import java.util.ArrayList;
import java.util.List;

public class CustomParseUtils {

    public static final String DELIMITER_COMMA = ",";
    public static final String EMPTY_SPACE = " ";
    public static final String EMPTY_STRING = "";

    public static List<Integer> stringToIntegerList(String str) {
        List<Integer> result = new ArrayList<>();
        String[] splitString = str.replace(EMPTY_SPACE, EMPTY_STRING).split(DELIMITER_COMMA);
        for (String s : splitString) {
            result.add(stringToInteger(s));
        }
        return result;
    }

    public static int stringToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NUMBER_FORMAT);
        }
    }
}
