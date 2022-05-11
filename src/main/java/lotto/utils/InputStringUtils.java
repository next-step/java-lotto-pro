package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputStringUtils {

    private static final String WHITE_SPACE = "\\s";
    private static final String NONE_SPACE = "";

    private InputStringUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static List<Integer> splitToNumberListByDelimiter(String inputString, String delimiter) {
        inputString = inputString.replaceAll(WHITE_SPACE, NONE_SPACE);
        List<Integer> numberList = new ArrayList<>();
        for (String numberWord : inputString.split(delimiter)) {
            numberList.add(wordToNumber(numberWord));
        }
        return numberList;
    }

    private static int wordToNumber(String numberWord) {
        if (numberWord.matches("\\p{Digit}+")) {
            return Integer.parseInt(numberWord);
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
    }
}
