import java.util.Objects;

public class StringAddCalculator {

    public int calculate(String text) {
        if(Objects.isNull(text) || text.isEmpty()) return 0;
        int[] numbers = stringsToNumbers(splitString(text));
        return sum(numbers);
    }

    private String[] splitString(String text) {
        return text.split(",|:");
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers)
        {
            sum += number;
        }
        return sum;
    }

    private int[] stringsToNumbers(String[] splitStrings) {
        int[] numbers = new int[splitStrings.length];
        for(int i=0;i<splitStrings.length;i++)
        {
            numbers[i] = stringToNumber(splitStrings[i]);
            validateNegative(numbers[i]);
        }
        return numbers;
    }

    private int stringToNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegative(int number) {
        if(number < 0) throw new IllegalArgumentException();
    }
}
