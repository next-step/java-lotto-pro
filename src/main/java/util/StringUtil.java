package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    private static final String DEFAULT_DELIMITER = ",";

    private StringUtil() {
    }

    public static boolean isEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    public static List<Integer> splitNumbersString(final String numbers, final String delimiter) {
        if (StringUtil.isEmpty(numbers)) {
            return new ArrayList<>();
        }

        if (StringUtil.isEmpty(delimiter)) {
            return extractNumberListFromString(numbers, DEFAULT_DELIMITER);
        }

        return extractNumberListFromString(numbers, delimiter);
    }

    private static List<Integer> extractNumberListFromString(final String numbers, final String delimiter) {
        List<Integer> numberList = new ArrayList<>();

        String[] numberStrings = numbers.split(delimiter);
        for (String numberString : numberStrings) {
            addNumberToList(numberList, numberString.trim());
        }

        return numberList;
    }

    private static void addNumberToList(final List<Integer> numberList, final String numberString) {
        if (StringUtil.isEmpty(numberString)) {
            return;
        }

        numberList.add(Integer.parseInt(numberString));
    }
}
