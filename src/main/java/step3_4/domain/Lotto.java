package step3_4.domain;

public class Lotto {

    private final UniqueNumbers numbers;

    private Lotto(UniqueNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto generate(UniqueNumbers numbers) {
        return new Lotto(numbers);
    }

    public int getCountOfMatch(UniqueNumbers numbers) {
        validateNumbersSize(numbers);
        return this.numbers.match(numbers);
    }

    private void validateNumbersSize(UniqueNumbers numbers) {
        if (!this.numbers.isEqualSize(numbers)) {
            throw new IndexOutOfBoundsException("Incomparable subject. please check lottoNumbers size.");
        }
    }

    @Override
    public String toString() {
        return "[" + numbers.toString() + "]";
    }
}
