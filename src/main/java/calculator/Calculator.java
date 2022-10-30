package calculator;

import calculator.util.Validator;
import java.util.stream.Stream;

class Calculator {
    int sum(Numbers numbers) {
        return Stream.of(numbers.getNumbers())
                .peek(Validator::isPositiveNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
