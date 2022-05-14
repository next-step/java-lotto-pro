import java.util.List;
public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }
        List<Integer> numbers = StringSplitter.getNumbers(expression);
        return sum(numbers);
    }

    private static boolean isEmpty(String expression) {
        return expression == null || "".equals(expression);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(i->i).sum();
    }
}
