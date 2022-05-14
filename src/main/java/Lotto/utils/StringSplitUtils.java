package Lotto.utils;

import Lotto.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StringSplitUtils {
    private static final String BASIC_DELIMITER = ", ";

    public static List<Integer> basicDetermiterSplit(String number) {
        return StringtoIntegerList(Arrays.asList(number.split(BASIC_DELIMITER)));
    }

    private static List<Integer> StringtoIntegerList(List<String> numbers) {
        List<Integer> results = new ArrayList<>();
        try {
            numbers.stream().forEach(num -> results.add(Integer.parseInt(num)));
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LastPrizeNumberGenerate.getErrorMsg());
        }
        return results;
    }
}
