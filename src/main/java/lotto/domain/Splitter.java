package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    private static final String DELIMITER = ",";

    public static List<Integer> split(String value) {
        return Arrays.stream(value.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
