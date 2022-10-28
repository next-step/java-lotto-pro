package stringadder;

import java.util.Arrays;
import java.util.Objects;

public class StringAdder {
    private static final String DELIMITER = "[,:]";
    private static final int INIT_VALUE = 0;

    public int calculate(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return INIT_VALUE;
        }

        final String[] tokens = value.split(DELIMITER);

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .reduce(INIT_VALUE, Integer::sum);
    }
}
