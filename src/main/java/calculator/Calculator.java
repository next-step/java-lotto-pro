package calculator;

import calculator.util.Validator;

import java.util.stream.Stream;

public class Calculator {
    private final Validator validator = new Validator();
    int sum(String[] numbers){
        return Stream.of(numbers)
                .peek(validator::isNumber)
                .mapToInt(Integer::parseInt)
                .peek(validator::isPositiveNumber)
                .sum();
    }
}
