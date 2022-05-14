package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class CustomParseUtils {
    public static List<Integer> stringToIntegerList(String str) {
        List<Integer> result = new ArrayList<>();
        String[] splitString = str.replace(" ", "").split(",");
        for (String s : splitString) {
            result.add(stringToInteger(s));
        }
        return result;
    }

    private static Integer stringToInteger(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 정상 숫자가 아닙니다.");
        }
    }
}
