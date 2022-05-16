package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    public static List<Integer> stringToArrayInteger(String text, String splitValue) {
        return Arrays.stream(text.split(splitValue))
                .map(NumberUtil::parseStringToInt)
                .collect(Collectors.toList());
    }
}
