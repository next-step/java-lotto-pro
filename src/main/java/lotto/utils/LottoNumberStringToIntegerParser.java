package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberStringToIntegerParser {

    private LottoNumberStringToIntegerParser() {}

    public static List<Integer> parse(String[] numbers) {
        return Arrays.stream(numbers)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static Integer parse(String number){
        return Integer.parseInt(number.trim());
    }
}
