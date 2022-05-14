package calculator.domain;


public class ArrayCalculator {
    private ArrayCalculator() {
    }
    
    public static int sum(PositiveNumber[] numbers) {
        PositiveNumber result = PositiveNumber.of(0);
        for (PositiveNumber number : numbers) {
            result = result.add(number);
        }
        return result.toNumber();
    }
}
