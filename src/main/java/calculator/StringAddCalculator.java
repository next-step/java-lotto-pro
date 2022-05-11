package calculator;

import calculator.utils.StringParser;
import calculator.utils.StringSplitter;
import calculator.utils.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Integer DEFAULT_RESULT_VALUE = 0;

    public static Integer splitAndSum(String string) {
        if (StringUtil.isNullOrEmpty(string)) {
            return DEFAULT_RESULT_VALUE;
        }

        String[] splitString = StringSplitter.split(string);
        List<Integer> integers = mapToIntegerList(splitString);

        return sumIntegerList(integers);
    }

    private static List<Integer> mapToIntegerList(String[] strings) {
        return Arrays
                .stream(strings)
                .map(string -> StringParser.parseAsInteger(string))
                .collect(Collectors.toList());
    }

    private static Integer sumIntegerList(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }
}
