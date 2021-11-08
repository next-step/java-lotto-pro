package step3.domain.strategy.numbers;

public class ManualLottoNumbers implements NumbersStrategy {
    private int[] numbers;

    public ManualLottoNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
