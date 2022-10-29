package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerConvertor {
    private StringToIntegerConvertor() {
    }

    public static List<Integer> convertNumbers(String[] values) {
        List<Integer> results = new ArrayList<>();
        for (String str : values) {
            results.add(convertNumber(str));
        }
        return results;
    }

    public static int convertNumber(String value) {
        return Integer.parseInt(value.trim());
    }
}
