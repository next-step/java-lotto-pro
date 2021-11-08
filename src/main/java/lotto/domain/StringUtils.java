package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static List<Integer> convertIntegerList(String input) {
        String[] split = input.split(", ");
        List<Integer> list = new ArrayList<>();
        for (String str : split) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}
