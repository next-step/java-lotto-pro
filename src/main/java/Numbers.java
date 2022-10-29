import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
