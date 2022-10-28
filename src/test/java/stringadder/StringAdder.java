package stringadder;

import java.util.Arrays;
import java.util.Objects;

public class StringAdder {
    public int calculate(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return PositiveInt.ZERO.toInt();
        }

        final AddExpression expression = new AddExpression(value);

        final String[] tokens = expression.parseTokens();

        return Arrays.stream(tokens)
                .map(PositiveInt::parse)
                .reduce(PositiveInt.ZERO, PositiveInt::plus)
                .toInt();
    }
}
