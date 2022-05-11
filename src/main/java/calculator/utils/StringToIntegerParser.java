package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerParser {

    private StringToIntegerParser(){
        throw new AssertionError();
    }

    public static List<Integer> parseNumbers(String[] strings) {
        return Arrays.stream(strings)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
