package stringadder;

import java.util.Objects;

public class StringAdder {
    public int calculate(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(value);
    }
}
