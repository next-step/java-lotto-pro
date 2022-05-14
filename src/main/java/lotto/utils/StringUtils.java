package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> convertToList(String value, String delimiter) {
        String[] splitValue = value.split(delimiter);

        List<Integer> result = new ArrayList<>();
        for (String stringNumber : splitValue) {
            result.add(Integer.parseInt(stringNumber));
        }
        return result;
    }
}
