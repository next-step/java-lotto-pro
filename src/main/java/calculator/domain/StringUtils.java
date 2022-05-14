package calculator.domain;

public class StringUtils {

    private StringUtils() {
    }

    public static PositiveNumber[] toPositiveNumbers(String[] inputs) {

        PositiveNumber[] result = new PositiveNumber[inputs.length];
        for (int index = 0; index < inputs.length; index++) {
            result[index] = PositiveNumber.of(inputs[index]);
        }
        return result;
    }
}
