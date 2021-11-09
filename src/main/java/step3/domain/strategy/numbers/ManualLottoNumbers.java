package step3.domain.strategy.numbers;

import java.util.List;

public class ManualLottoNumbers implements NumbersStrategy {
    private final List<Integer> numbers;

    public ManualLottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
