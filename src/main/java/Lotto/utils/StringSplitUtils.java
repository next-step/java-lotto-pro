package Lotto.utils;

import Lotto.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StringSplitUtils {
    private static final String BASIC_DELIMITER = ",";

    public static List<Integer> basicDetermiterSplit(String number) {
        return stringtoIntegerList(Arrays.asList(number.split(BASIC_DELIMITER)));
    }

    private static List<Integer> stringtoIntegerList(List<String> numbers) {
        List<Integer> results = new ArrayList<>();
        try {
            numbers.stream().forEach(num -> results.add(Integer.parseInt(num.trim())));
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LastPrizeNumberGenerate.getErrorMsg());
        }

        if(results.size() != 6)
            throw new IllegalArgumentException(ErrorMessage.LastPrizeNumberCount.getErrorMsg());

        return results;
    }
}
