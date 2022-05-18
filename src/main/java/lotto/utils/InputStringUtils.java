package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputStringUtils {

    private static final String WHITE_SPACE = "\\s";
    private static final String NONE_SPACE = "";

    private InputStringUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static List<String> nonSpaceSplit(String inputString, String delimiter) {
        inputString = inputString.replaceAll(WHITE_SPACE, NONE_SPACE);
        return new ArrayList<>(Arrays.asList(inputString.split(delimiter)));
    }
}
