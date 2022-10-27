package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    private LottoNumbers() {
        this.numbers = new ArrayList<>();
    }

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers generate(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public int getSize() {
        return numbers.size();
    }
}
