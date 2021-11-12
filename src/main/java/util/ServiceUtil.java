package util;

import lotto.domain.common.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceUtil {

    public static List<Integer> splitNumbers(final String input) {
        String[] dividedNumbers = input.trim().split(Constant.SEPERATOR);
        return Arrays.stream(dividedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
