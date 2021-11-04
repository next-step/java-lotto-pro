package lotto.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtils {
    private static final String SEPARATOR = ", |,";
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    public static List<String> separate(String inputString) {
        List<String> result = Arrays.asList(inputString.split(SEPARATOR));
        validateList(result);
        return result;
    }

    private static void validateList(List<String> result) {
        if (result.size() != LOTTO_NUMBER_MAX_COUNT) {
            throw new IllegalArgumentException("6개 번호를 입력하세요.");
        }
        checkDupleNumber(result);
    }

    private static void checkDupleNumber(List<String> result) {
        Set<Integer> dupleCheckSet = new HashSet<>();
        for (String string : result) {
            dupleCheckSet.add(Integer.parseInt(string));
        }

        if (dupleCheckSet.size() != LOTTO_NUMBER_MAX_COUNT) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }
    }
}
