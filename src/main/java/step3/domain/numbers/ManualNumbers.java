package step3.domain.numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumbers implements NumbersStrategy {
    private int[] numbers;

    public ManualNumbers(int... numbers) {
        sort(numbers);
        map(numbers);
    }

    private void map(int[] numbers) {
        this.numbers = numbers;
    }

    private void sort(int[] numbers) {
        Arrays.sort(numbers);
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
