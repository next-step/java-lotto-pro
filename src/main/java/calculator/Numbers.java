package calculator;

public class Numbers {

    private final String[] numbers;

    public Numbers(String[] numbers) {
        validateNegativeNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validateNegativeNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNegativeNumber(number);
        }
    }

    private static void validateNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int sum() {
        int sum = 0;
        for (String number : this.numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
