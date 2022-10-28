package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerConvertor {
    private StringToIntegerConvertor() {
    }

    public static List<Integer> convertNumbers(String[] values) {
        List<Integer> results = new ArrayList<>();
        for (String str : values) {
            results.add(Integer.parseInt(str.trim()));
        }
        return results;
    }
}
