package step3.domain;

public class Lotto {

    private final Numbers numbers;

    private Lotto(Numbers numbers) {
        validateInputNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate(Numbers numbers) {
        return new Lotto(numbers);
    }

    public int getCountOfMatch(Numbers numbers) {
        validateNumbersSize(numbers);
        return this.numbers.match(numbers);
    }

    private void validateInputNumbers(Numbers numbers) {
        if (numbers.isDuplicated()) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
    }

    private void validateNumbersSize(Numbers numbers) {
        if (!this.numbers.isEqualSize(numbers)) {
            throw new IndexOutOfBoundsException("Incomparable subject. please check lottoNumbers size.");
        }
    }

    @Override
    public String toString() {
        return "[" + numbers.toString() + "]";
    }
}